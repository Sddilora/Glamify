package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.ShoppingSession;

public interface ShoppingSessionRepository extends CrudRepository<ShoppingSession, Long>{
    
}
