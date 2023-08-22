package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.Discount;

public interface DiscountRepository extends CrudRepository<Discount, Long>{
    
}
