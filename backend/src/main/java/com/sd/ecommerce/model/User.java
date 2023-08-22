package com.sd.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity(name = "User") // represents a table
@Getter // reduce boilerplate code, it generates getters for all fields
@Setter // reduce boilerplate code, it generates setters for all fields
@NoArgsConstructor // Is useful when instances of the class need to be created without providing any initial values for the fields.
@AllArgsConstructor // generates a constructor that includes parameters for initializing all fields of the class.
@Table(name = "user")
public class User extends BaseEntity{

    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="user_user_address", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="user_address_id"))
    private List<UserAddress> userAddresses = new ArrayList<>();
}
