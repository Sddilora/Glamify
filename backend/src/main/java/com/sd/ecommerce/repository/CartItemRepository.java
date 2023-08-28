package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{
    
}
