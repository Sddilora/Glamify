package com.sd.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import com.sd.ecommerce.model.User;
// By simply extending JpaRepository, we inherit methods for creating and querying our User entity.
public interface UserRepository extends CrudRepository<User, Long> {
    // @Query("SELECT u FROM User u WHERE u.email = :email")
    // Optional<User> findByEmail(@Param("email") String email);
}
