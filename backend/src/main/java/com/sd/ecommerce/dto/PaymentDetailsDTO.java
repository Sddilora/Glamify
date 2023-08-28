package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import com.sd.ecommerce.model.OrderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsDTO {

        // BaseEntity
        private Long id;
        // BaseEntityAudit
        private Timestamp createdAt;
        private Timestamp updatedAt;

        private OrderDetails orderDetails;
        private String provider;
        private String status;
        private int amount;

}
