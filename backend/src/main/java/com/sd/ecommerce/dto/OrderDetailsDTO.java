package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import com.sd.ecommerce.model.PaymentDetails;
import com.sd.ecommerce.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {

    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    private User user;
    private float total;
    private PaymentDetails paymentDetails;

}
