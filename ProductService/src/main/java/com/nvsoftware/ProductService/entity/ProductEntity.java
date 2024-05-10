package com.nvsoftware.ProductService.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

@Entity //is an entity
@Data   //auto generate getter and setter
@AllArgsConstructor //argument constructor
@NoArgsConstructor  //no argument constructor
@Builder    //???

public class ProductEntity {
    @Id // primary key in DB
    @GeneratedValue(strategy = GenerationType.AUTO) //generated automatically (e.g. 1, 2, 3...)
    private long id;
    @Column(name = "PRODUCT_NAME") // name differently in DB
    private String name;
    private long price;
    private long quantity;
}
