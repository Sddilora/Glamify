package com.sd.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.sd.ecommerce.model.Base.BaseEntityAudit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Users") // represents a table
@Getter // reduce boilerplate code, it generates getters for all fields
@Setter // reduce boilerplate code, it generates setters for all fields
@NoArgsConstructor // Is useful when instances of the class need to be created without providing any initial values for the fields.
// @AllArgsConstructor // generates a constructor that includes parameters for initializing all fields of the class.
@Table(name = "users")
public class User extends BaseEntityAudit{

    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="user_user_address", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="user_address_id"))
    private List<UserAddress> userAddresses = new ArrayList<>();

    public User orElseThrow(Object object) {
        return null;
    }

    // All args constructor
    public User(Long id, String userName, String password, String email, String firstName, String lastName, String phone, List<UserAddress> userAddresses) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userAddresses = userAddresses;
    }

}
