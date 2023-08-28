package com.sd.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.sd.ecommerce.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDTO {

    // BaseEntity
    private Long id;
    
    private String addressLine;
    private String city;
    private String country;
    private String postalCode;
    
    private List<User> users = new ArrayList<>();

}
