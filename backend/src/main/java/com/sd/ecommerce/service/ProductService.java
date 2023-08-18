package com.sd.ecommerce.service;

import java.util.Collection;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.sd.ecommerce.model.Product;

@Validated // This means that this class will be validated by Spring.
public interface ProductService {

    Product save(Product product);

    Product get(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product update(@Min(value = 1L, message = "Invalid product ID.") long id, Product product);

    // Soft Delete
    Product delete(@Min(value = 1L, message = "Invalid product ID.") long id);

    Collection<Product> list();
}

    // // Ex version
    
    // @NotNull Iterable<Product> getAllProducts();

    // Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);
    // // @Min is a validation annotation that makes sure that the value of the parameter is at least 1L (1 long). 
    // // If the value is less than 1L, then the message "Invalid product ID." will be returned.

    // Product save(Product product);
    // // This method will be used to save a product to the database.
    // // The @Validated annotation will make sure that the product object is validated before it is saved to the database.
    // // save came from the CrudRepository interface that we extended in the ProductRepository interface.