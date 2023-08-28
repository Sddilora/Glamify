package com.sd.ecommerce.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
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
public class UserDTO {

    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private List<UserAddress> userAddresses = new ArrayList<>();

    public UserDTO(Long id, Timestamp createdAt, Timestamp updatedAt, String userName, String email, String firstName, String lastName, String phone) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
