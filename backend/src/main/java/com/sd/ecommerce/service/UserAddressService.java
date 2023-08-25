package com.sd.ecommerce.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.User;
import com.sd.ecommerce.model.UserAddress;
import com.sd.ecommerce.repository.UserAddressRepository;
import com.sd.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class UserAddressService{
    
    private final UserAddressRepository userAddressRepository;
    private final UserRepository UserRepository;

    public UserAddress save(UserAddress userAddress) {
        log.info("Saving new UserAddress {} to the database", userAddress.getAddressLine());
        
        // List<Long> userIds = userAddress.getUserIds();
        List<Long> userIds = userAddress.getUsers().stream().map(User::getId).collect(Collectors.toList());

        // List<User> users = UserRepository.findAllById(userIds);
        List<User> users = new ArrayList<User>();
        for (Long userId : userIds) {
            User user = UserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with provided ID not found"));
            users.add(user);
        }

        UserAddress newUserAddress = new UserAddress();
        newUserAddress.setAddressLine(userAddress.getAddressLine());
        newUserAddress.setCity(userAddress.getCity());
        newUserAddress.setCountry(userAddress.getCountry());
        newUserAddress.setPostalCode(userAddress.getPostalCode());
        newUserAddress.setUsers(users);

        return userAddressRepository.save(newUserAddress);
    }

    public UserAddress get(Long id) {
        log.info("Fetching UserAddress {}", id);
        return userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
    }

    public UserAddress update(Long id, UserAddress userAddress) {
        log.info("Updating UserAddress {} with {}", id, userAddress.toString());
        UserAddress existingUserAddress = userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
        existingUserAddress.setAddressLine(userAddress.getAddressLine());
        existingUserAddress.setCity(userAddress.getCity());
        existingUserAddress.setCountry(userAddress.getCountry());
        existingUserAddress.setPostalCode(userAddress.getPostalCode());
        existingUserAddress.setUsers(userAddress.getUsers());
        return userAddressRepository.save(existingUserAddress);
    }

    public UserAddress delete(Long id) {
        log.info("Deleting UserAddress {}", id);
        UserAddress existingUserAddress = userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
        userAddressRepository.deleteById(id);
        return existingUserAddress;
    }

    public Collection<UserAddress> list() {
        log.info("Fetching all UserAddresses");
        return (Collection<UserAddress>) userAddressRepository.findAll();
    }
}
