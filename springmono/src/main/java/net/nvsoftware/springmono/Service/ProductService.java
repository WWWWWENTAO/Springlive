package net.nvsoftware.springmono.Service;


import net.nvsoftware.springmono.model.Product;
import org.springframework.objenesis.SpringObjenesis;

import java.util.List;

public interface ProductService {
    Product save (Product product);

    List<Product> getAll();

    Product getById(String id);

    String deleteById(String id);

}
