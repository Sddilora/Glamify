package com.sd.ecommerce.service;

import com.sd.ecommerce.repository.UserAddressRepository;
import com.sd.ecommerce.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.UserDTO;
import com.sd.ecommerce.dto.UserRegistrationDTO;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.User;
import com.sd.ecommerce.model.UserAddress;
import com.sd.ecommerce.dto.Mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class UserService{

    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;
    private final UserMapper UserMapper;

    // Register a new user
    public UserRegistrationDTO save(UserRegistrationDTO UserRegistrationDTO) {
        log.info("Saving new User {} to the database", UserRegistrationDTO.getUserName());
        List<Long> userAddressIds = UserRegistrationDTO.getUserAddresses().stream().map(UserAddress::getId).collect(Collectors.toList());

        List<UserAddress> userAddresses = new ArrayList<UserAddress>();
        for (Long userAddressId : userAddressIds) {
            System.out.println("userAddressId: " + userAddressId);
            UserAddress userAddress = userAddressRepository.findById(userAddressId).orElseThrow(() -> new ResourceNotFoundException("User Address with provided ID not found"));
            userAddresses.add(userAddress);
        }

        User newUser = new User();
        newUser.setUserName(UserRegistrationDTO.getUserName());
        newUser.setFirstName(UserRegistrationDTO.getFirstName());
        newUser.setLastName(UserRegistrationDTO.getLastName());
        newUser.setEmail(UserRegistrationDTO.getEmail());
        newUser.setPassword(UserRegistrationDTO.getPassword());
        newUser.setPhone(UserRegistrationDTO.getPhone());
        newUser.setUserAddresses(userAddresses);
        // user.setPassword(hashPassword(user.getPassword()));
        return UserMapper.convertRegToDTO(userRepository.save(UserMapper.convertToEntity(UserRegistrationDTO)));
    }
    
    public UserDTO get(Long id) {
        log.info("Fetching User {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.convertUserToDTO(user);
    }

    public UserRegistrationDTO update(Long id, UserRegistrationDTO UserRegistrationDTO) {
        log.info("Updating User {} with {}", id, UserRegistrationDTO.toString());
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Long> userAddressIds = UserRegistrationDTO.getUserAddresses().stream().map(UserAddress::getId).collect(Collectors.toList());
        // List<UserAddress> userAddresses = new ArrayList<UserAddress>(); // This cause the lost of the previous addresses
        List<UserAddress> userAddresses = new ArrayList<>(existingUser.getUserAddresses());

        for (Long userAddressId : userAddressIds) {
            UserAddress userAddress = userAddressRepository.findById(userAddressId).orElseThrow(() -> new ResourceNotFoundException("User Address with provided ID not found"));
            userAddresses.add(userAddress);
        }
        existingUser.setUserName(UserRegistrationDTO.getUserName());
        // existingUser.setPassword(hashPassword(user.getPassword()));
        existingUser.setPassword((UserRegistrationDTO.getPassword()));
        existingUser.setEmail(UserRegistrationDTO.getEmail());
        existingUser.setFirstName(UserRegistrationDTO.getFirstName());
        existingUser.setLastName(UserRegistrationDTO.getLastName());
        existingUser.setPhone(UserRegistrationDTO.getPhone());
        existingUser.setUserAddresses(userAddresses);
        return UserMapper.convertRegToDTO(existingUser);
    }

    public UserDTO delete(Long id) {
        log.info("Deleting User {}", id);
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.deleteById(id);
        return UserMapper.convertUserToDTO(existingUser);
    }

    public Collection<UserDTO> list() {
        log.info("Fetching all Users");
        Iterable<User> usersIterable = userRepository.findAll();
        Collection<User> usersCollection = new ArrayList<>();
        usersIterable.forEach(usersCollection::add);
        return UserMapper.convertUsersToDTOs(usersCollection);
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

