package com.sd.ecommerce.dto.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.UserAuthDTO;
import com.sd.ecommerce.dto.UserDTO;
import com.sd.ecommerce.dto.UserRegistrationDTO;
import com.sd.ecommerce.model.User;

@Component
public class UserMapper {
    
    // Conversion method from UserDTO to User entity
    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        return user;
    }

    // Conversion method from UserRegistrationDTO to User entity
    public User convertToEntity(UserRegistrationDTO registrationDTO) {
        // String hashedPassword = UserServiceImpl.hashPassword(registrationDTO.getPassword());
        User user = new User();
        user.setUserName((registrationDTO.getUserName()));
        user.setPassword(registrationDTO.getPassword());
        user.setEmail(registrationDTO.getEmail());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setPhone(registrationDTO.getPhone());
        user.setUserAddresses(registrationDTO.getUserAddresses());
        return user;
    }

    // Conversion method from UserAuthDTO to User entity
    public User convertToEntity(UserAuthDTO userAuthDTO) {
        User user = new User();
        user.setEmail(userAuthDTO.getEmail());
        user.setPassword(userAuthDTO.getPassword());
        return user;
    }

    // Conversion method from User entity to UserAuthDTO
    public UserAuthDTO convertAuthToDTO(User user) {
        return new UserAuthDTO(user.getEmail(), user.getPassword());
    }

    // Conversion method from User entity to UserDTO
    public UserDTO convertUserToDTO(User user) {
        return new UserDTO(user.getId(), user.getCreatedAt(), user.getUpdatedAt(), user.getUserName(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getUserAddresses());
    }

    // Conversion method from User entity to UserRegistrationDTO
    public UserRegistrationDTO convertRegToDTO(User user) {
        return new UserRegistrationDTO(user.getId(), user.getCreatedAt(), user.getUpdatedAt(), user.getUserName(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getUserAddresses(), user.getPassword());
    }

    // Conversion method from a collection of User entities to a list of UserDTOs
    public List<UserDTO> convertUsersToDTOs(Collection<User> users) {
        return users.stream().map(this::convertUserToDTO).collect(Collectors.toList());
    }
    
}