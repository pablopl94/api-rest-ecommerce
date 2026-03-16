package com.ecommerce.product.infrastructure.api.mapper;

import com.ecommerce.product.application.command.create.ProductCreateRequest;
import com.ecommerce.product.application.command.update.ProductUpdateRequest;
import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.infrastructure.api.dto.ProductRequestDto;
import com.ecommerce.product.infrastructure.api.dto.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    ProductCreateRequest mapRequestToCreate(ProductRequestDto productRequestDto);

    ProductUpdateRequest mapRequestToUpdate(ProductRequestDto productRequestDto);

    ProductResponseDto mapProductToResponse(Product product);
}
