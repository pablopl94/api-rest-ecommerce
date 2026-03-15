package com.ecommerce.product.infrastructure.database.mapper;

import com.ecommerce.product.domain.entity.Product;
import com.ecommerce.product.infrastructure.database.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper {

    ProductEntity mapProductToEntity(Product product);

    Product mapEntityToProduct(ProductEntity entity);

}
