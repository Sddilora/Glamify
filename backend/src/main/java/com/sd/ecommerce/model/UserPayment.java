package com.sd.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserPayment extends BaseEntity{
    // @OneToMany(mappedBy = "userPayment", cascade = CascadeType.ALL) // Define the one-to-many relationship
    // private List<UserPayment> paymentMethods; // Use a collection type for payment methods

    @ManyToOne
    private User user;

    private String paymentType;

    private String provider;

    private int account_no;

    private LocalDate expiry_date;
}
