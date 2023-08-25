package com.sd.ecommerce.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    // @OneToMany(mappedBy = "userPayment", cascade = CascadeType.ALL) // Define the one-to-many relationship
    // private List<UserPayment> paymentMethods; // Use a collection type for payment methods

    @ManyToOne
    private User user;

    private String paymentType;

    private String provider;

    private int account_no;

    private LocalDate expiry_date;
}
