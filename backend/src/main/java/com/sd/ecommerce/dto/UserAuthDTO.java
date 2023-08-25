package com.sd.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthDTO {
        
    private String email;
    private String password;

    public UserAuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
