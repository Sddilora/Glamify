package com.sd.ecommerce.service.implementation;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.UserAddress;
import com.sd.ecommerce.repository.UserAddressRepository;
import com.sd.ecommerce.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class UserAddressServiceImpl implements BaseService<UserAddress>{
    
    private final UserAddressRepository userAddressRepository;

    @Override
    public UserAddress save(UserAddress userAddress) {
        log.info("Saving new UserAddress {} to the database", userAddress.getId());
        return userAddressRepository.save(userAddress);
    }

    @Override
    public UserAddress get(Long id) {
        log.info("Fetching UserAddress {}", id);
        return userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
    }

    @Override
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

    @Override
    public UserAddress delete(Long id) {
        log.info("Deleting UserAddress {}", id);
        UserAddress existingUserAddress = userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
        userAddressRepository.deleteById(id);
        return existingUserAddress;
    }

    @Override
    public Collection<UserAddress> list() {
        log.info("Fetching all UserAddresses");
        return (Collection<UserAddress>) userAddressRepository.findAll();
    }
}
