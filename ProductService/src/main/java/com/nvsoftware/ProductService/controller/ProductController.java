package com.nvsoftware.ProductService.controller;

import com.nvsoftware.ProductService.model.ProductRequest;
import com.nvsoftware.ProductService.model.ProductResponse;
import com.nvsoftware.ProductService.service.ProductService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long id = productService.addProduct(productRequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductResponseById (@PathVariable long id) {
        ProductResponse productResponse = productService.getById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK); // HTTP 200
    }

    @PutMapping("/reduceQuantity")
    public ResponseEntity<Void> reduceQuantity(@RequestParam long id, @RequestParam long quantity) {
        productService.reduceQuantity(id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
