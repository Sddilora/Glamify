package com.sd.ecommerce.dto;

import java.time.LocalDate;

import com.sd.ecommerce.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPaymentDTO {

    // BaseEntity
    private Long id;
    
    private User user;
    private String paymentType;
    private String provider;
    private int account_no;
    private LocalDate expiry_date;
}
