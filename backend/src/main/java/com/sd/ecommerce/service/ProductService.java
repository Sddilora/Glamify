package com.sd.ecommerce.service;

import java.util.Collection;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.sd.ecommerce.model.Product;

@Validated // This means that this class will be validated by Spring.
public interface ProductService {

    Product save(Product product);

    Product get(@Min(value = 1L, message = "Invalid product ID.") Long id);

    Product update(@Min(value = 1L, message = "Invalid product ID.") Long id, Product product);

    // Soft Delete
    Product delete(@Min(value = 1L, message = "Invalid product ID.") Long id);

    Collection<Product> list();
}
