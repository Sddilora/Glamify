package com.sd.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "UserAddress")
@Table(name = "user_address")
public class UserAddress extends BaseEntity{

    private String addressLine;
    private String city;
    private String country;
    private String postalCode;
    
    @ManyToMany(mappedBy = "userAddresses", fetch = javax.persistence.FetchType.LAZY)
    private List<User> users = new ArrayList<>();

}

// TODO add adress header ( home, work etc)  