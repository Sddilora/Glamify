package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.UserAddress;

public interface UserAddressRepository extends CrudRepository <UserAddress, Long> {
    
}
