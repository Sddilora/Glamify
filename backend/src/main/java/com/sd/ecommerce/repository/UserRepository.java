package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.sd.ecommerce.model.User;


// By simply extending JpaRepository, we inherit methods for creating and querying our User entity.
public interface UserRepository extends CrudRepository<User, Long> {
    
}
