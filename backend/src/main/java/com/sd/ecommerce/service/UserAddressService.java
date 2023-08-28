package com.sd.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.UserAddressDTO;
import com.sd.ecommerce.dto.Mapper.UserAddressMapper;
import com.sd.ecommerce.model.User;
import com.sd.ecommerce.model.UserAddress;
import com.sd.ecommerce.repository.UserAddressRepository;
import com.sd.ecommerce.repository.UserRepository;
import com.sd.ecommerce.util.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class UserAddressService{
    
    private final UserAddressRepository userAddressRepository;
    private final UserRepository UserRepository;
    private final UserAddressMapper userAddressMapper;

    public UserAddressDTO save(UserAddressDTO userAddressDTO) {
        log.info("Saving new UserAddress {} to the database", userAddressDTO.getAddressLine());
        
        // List<Long> userIds = userAddress.getUserIds();
        List<Long> userIds = userAddressDTO.getUsers().stream().map(User::getId).collect(Collectors.toList());

        // List<User> users = UserRepository.findAllById(userIds);
        List<User> users = new ArrayList<User>();
        for (Long userId : userIds) {
            User user = UserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with provided ID not found"));
            users.add(user);
        }

        UserAddress newUserAddress = new UserAddress();
        newUserAddress.setAddressLine(userAddressDTO.getAddressLine());
        newUserAddress.setCity(userAddressDTO.getCity());
        newUserAddress.setCountry(userAddressDTO.getCountry());
        newUserAddress.setPostalCode(userAddressDTO.getPostalCode());
        newUserAddress.setUsers(users);

        return userAddressMapper.convertToDTO(userAddressRepository.save(userAddressMapper.convertToEntity(userAddressDTO)));
    }

    public UserAddressDTO get(Long id) {
        log.info("Fetching UserAddress {}", id);
        return userAddressMapper.convertToDTO(userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress with provided ID not found")));
    }

    public UserAddressDTO update(Long id, UserAddressDTO userAddressDTO) {
        log.info("Updating UserAddress {} with {}", id, userAddressDTO.toString());
        UserAddress existingUserAddress = userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
        existingUserAddress.setAddressLine(userAddressDTO.getAddressLine());
        existingUserAddress.setCity(userAddressDTO.getCity());
        existingUserAddress.setCountry(userAddressDTO.getCountry());
        existingUserAddress.setPostalCode(userAddressDTO.getPostalCode());
        existingUserAddress.setUsers(userAddressDTO.getUsers());
        return userAddressMapper.convertToDTO(userAddressRepository.save(existingUserAddress));
    }

    public UserAddressDTO delete(Long id) {
        log.info("Deleting UserAddress {}", id);
        UserAddress existingUserAddress = userAddressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserAddress not found"));
        userAddressRepository.deleteById(id);
        return userAddressMapper.convertToDTO(existingUserAddress);
    }

    public List<UserAddressDTO> list() {
        log.info("Fetching all UserAddresses");
        return userAddressMapper.convertToDTO((List<UserAddress>) userAddressRepository.findAll());
    }
}
