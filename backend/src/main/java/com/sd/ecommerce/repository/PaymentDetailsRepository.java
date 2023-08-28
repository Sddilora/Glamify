package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.PaymentDetails;

public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails, Long>{
    
}
