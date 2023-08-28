package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.OrderDetails;

public interface OrderDetailsRepository  extends CrudRepository<OrderDetails, Long>{
    
}
