package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.UserAddressDTO;
import com.sd.ecommerce.model.UserAddress;

@Component
public class UserAddressMapper {

    public UserAddress convertToEntity(UserAddressDTO userAddressDTO) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(userAddressDTO.getId());
        userAddress.setAddressLine(userAddressDTO.getAddressLine());
        userAddress.setCity(userAddressDTO.getCity());
        userAddress.setCountry(userAddressDTO.getCountry());
        userAddress.setCountry(userAddressDTO.getCountry());
        userAddress.setPostalCode(userAddressDTO.getPostalCode());
        userAddress.setUsers(userAddressDTO.getUsers());
        return userAddress;
    }

    public UserAddressDTO convertToDTO(UserAddress userAddress) {
        return new UserAddressDTO(userAddress.getId(), userAddress.getAddressLine(), userAddress.getCity(), userAddress.getCountry(), userAddress.getPostalCode(), userAddress.getUsers());
    }

    public List<UserAddressDTO> convertToDTO(List<UserAddress> userAddresses) {
        return userAddresses.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
    
}
