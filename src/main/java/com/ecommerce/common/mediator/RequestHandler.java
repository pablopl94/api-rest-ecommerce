package com.ecommerce.common.mediator;

/**
 *
 * @param <T> Tipo de clase que va a hacer la petición
 * @param <R> Respuesta que vamos a devolver
 */
public interface RequestHandler<T extends Request<R>, R> {

    R handle(T request);

    Class<T> getRequestType();
}
