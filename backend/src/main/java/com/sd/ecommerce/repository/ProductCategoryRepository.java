package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.ProductCategory;

public interface ProductCategoryRepository  extends CrudRepository<ProductCategory, Long>{
    
}
