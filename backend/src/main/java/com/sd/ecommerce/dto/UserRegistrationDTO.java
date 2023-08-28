package com.sd.ecommerce.dto;

import java.sql.Timestamp;
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

    public UserRegistrationDTO(Long id, Timestamp createdAt, Timestamp updatedAt, String userName, String email, String firstName, String lastName, String phone, List<UserAddress> userAddresses, String password) {
        super(id, createdAt, updatedAt, userName, email, firstName, lastName, phone, userAddresses);
        this.password = password;
    }

    // public UserRegistrationDTO(String userName, String password, String email, String firstName, String lastName, String phone, List<UserAddress> userAddresses) {
    //     super(getId(), getCreatedAt(), getUpdatedAt(), getDeleted(), userName, email, firstName, lastName, phone, userAddresses)
    // }

    // public UserRegistrationDTO(String userName, String email, String firstName, String lastName, String phone,
    //         List<UserAddress> userAddresses) {
    // }
}
