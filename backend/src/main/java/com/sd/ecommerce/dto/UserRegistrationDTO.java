package com.sd.ecommerce.dto;

import java.util.List;
import com.sd.ecommerce.model.UserAddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO extends UserDTO{

    private String password;

    public UserRegistrationDTO(String userName, String email, String firstName, String lastName, String phone, String password, List<UserAddress> userAddresses) {
        super(userName, email, firstName, lastName, phone, userAddresses);
        this.password = password;
    }
}
