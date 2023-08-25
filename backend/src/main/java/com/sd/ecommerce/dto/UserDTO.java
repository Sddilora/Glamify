package com.sd.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.sd.ecommerce.model.UserAddress;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private List<UserAddress> userAddresses = new ArrayList<>();

    public UserDTO(String userName, String email, String firstName, String lastName, String phone, List<UserAddress> userAddresses) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userAddresses = userAddresses;
    }
}
