package com.sd.ecommerce.service;

import java.util.Collection;

import org.springframework.validation.annotation.Validated;

import com.sd.ecommerce.model.ProductCategory;

@Validated
public interface ProductCategoryService {

    ProductCategory save(ProductCategory productCategory);

    ProductCategory get(Long id);

    ProductCategory update(Long id, ProductCategory productCategory);

    // Soft Delete
    ProductCategory delete(Long id);

    Collection<ProductCategory> list();
    
}
