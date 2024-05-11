package com.nvsoftware.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

@Data // auto generate getter and setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // predefine some implementations

public class ProductResponse {
    private long id;
    private String name;
    private long price;
    private long quantity;
}
