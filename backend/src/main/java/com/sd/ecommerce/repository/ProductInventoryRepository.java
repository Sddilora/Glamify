package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.ProductInventory;

public interface ProductInventoryRepository extends CrudRepository<ProductInventory, Long>{
    
}
