package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
