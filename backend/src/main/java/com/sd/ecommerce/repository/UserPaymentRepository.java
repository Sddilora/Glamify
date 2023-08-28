package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{
    
}
