package com.sd.ecommerce.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity // represents a table
// @Data // reduce boilerplate code, it generates getters and setters for all fields
@Getter // reduce boilerplate code, it generates getters for all fields
@Setter // reduce boilerplate code, it generates setters for all fields
@NoArgsConstructor // Is useful when instances of the class need to be created without providing any initial values for the fields.
@AllArgsConstructor // generates a constructor that includes parameters for initializing all fields of the class.
@Table(name = "users")
public class User extends BaseEntity{

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    
}