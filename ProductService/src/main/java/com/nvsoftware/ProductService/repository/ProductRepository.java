package com.nvsoftware.ProductService.repository;

import com.nvsoftware.ProductService.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
@Repository //Declare it's a repository

public interface ProductRepository extends JpaRepository<ProductEntity, Long> { // Implement JPA like findall, findbyid ...

}
