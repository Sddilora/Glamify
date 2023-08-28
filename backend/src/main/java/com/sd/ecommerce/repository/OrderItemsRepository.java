package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.OrderItems;

public interface OrderItemsRepository  extends CrudRepository<OrderItems, Long>{
    
}
