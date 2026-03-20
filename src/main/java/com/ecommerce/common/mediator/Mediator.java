package com.ecommerce.common.mediator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Mediator {

    Map<? extends Class<?>, RequestHandler<?, ?>> requestHandlerMap;

    public Mediator(List<RequestHandler<?, ?>> requestHandlers) {
        requestHandlerMap = requestHandlers.stream().collect(Collectors.toMap(RequestHandler::getRequestType, Function.identity()));
    }

    public <T extends Request<R>, R> R dispatch(T request) {
        RequestHandler<T, R> handler = (RequestHandler<T, R>) requestHandlerMap.get(request.getClass());
        if (handler == null) {
            log.error("No handler found request type {}", request.getClass());
            throw new RuntimeException("No handle found for request type" + request.getClass());
        }
        return handler.handle(request);
    }

    @Async
    public <T extends Request<R>, R> void dispatchAsync(T request) {
        RequestHandler<T, R> handler = (RequestHandler<T, R>) requestHandlerMap.get(request.getClass());
        if (handler == null) {
            log.error("No handler found request type {}", request.getClass());
            throw new RuntimeException("No handle found for request type" + request.getClass());
        }
        handler.handle(request);
    }
}
