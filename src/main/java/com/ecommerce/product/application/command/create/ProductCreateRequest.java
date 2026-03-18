package com.ecommerce.product.application.command.create;

import com.ecommerce.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest implements Request<Long> {

    private String name;
    private String description;
    private Double price;
    private MultipartFile image;
}
