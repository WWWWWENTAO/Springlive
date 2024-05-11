package com.nvsoftware.ProductService.service;

import com.nvsoftware.ProductService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
