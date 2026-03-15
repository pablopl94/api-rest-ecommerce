package com.ecommerce.product.application.command.delete;

import com.ecommerce.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDeleteRequest implements Request<Void> {

    private Long id;

}
