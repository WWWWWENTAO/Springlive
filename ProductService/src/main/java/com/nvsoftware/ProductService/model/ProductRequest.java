package com.nvsoftware.ProductService.model;

import lombok.Data;

@Data //auto generate getter and setter
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;
}
