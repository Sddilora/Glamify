package com.sd.ecommerce.service.implementation;

import com.sd.ecommerce.repository.UserRepository;
import com.sd.ecommerce.service.BaseService;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.UserAuthDTO;
import com.sd.ecommerce.dto.UserDTO;
import com.sd.ecommerce.dto.UserRegistrationDTO;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class UserServiceImpl implements BaseService<User>{

    private final UserRepository userRepository;

    // Register a new user
    @Override
    public User save(User user) {
        log.info("Saving new User {} to the database", user.getId());
        // user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }
    
    @Override
    public User get(Long id) {
        log.info("Fetching User {}", id);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User update(Long id, User user) {
        log.info("Updating User {} with {}", id, user.toString());
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        existingUser.setUserName(user.getUserName());
        // existingUser.setPassword(hashPassword(user.getPassword()));
        existingUser.setPassword((user.getPassword()));
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhone(user.getPhone());
        existingUser.setUserAddresses(user.getUserAddresses());
        return userRepository.save(existingUser);
    }

    @Override
    public User delete(Long id) {
        log.info("Deleting User {}", id);
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.deleteById(id);
        return existingUser;
    }

    @Override
    public Collection<User> list() {
        log.info("Fetching all Users");
        return (Collection<User>) userRepository.findAll();
    }

    // public boolean authenticateUser(User user) {
    //     Long id = user.getId();
    //     String password = user.getPassword();

    //     // Check the hashed password against the stored hash
    //     User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    //     return BCrypt.checkpw(password, existingUser.getPassword());
        

    // }

    // public String hashPassword(String password) {
    //     return BCrypt.hashpw(password, BCrypt.gensalt());
    // }
    
}

