package com.nvsoftware.ProductService.service;

import com.nvsoftware.ProductService.model.ProductRequest;
import com.nvsoftware.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getById(long id);

}
