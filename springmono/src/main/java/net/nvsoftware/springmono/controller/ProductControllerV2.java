package net.nvsoftware.springmono.controller;

import net.nvsoftware.springmono.Service.ProductService;
import net.nvsoftware.springmono.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/poduct")

public class ProductControllerV2 {
    @Qualifier("productServiceImplV2")
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product save(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @GetMapping("")
    public List<Product> getAllProduct(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) {
        return productService.deleteById(id);
    }
}
