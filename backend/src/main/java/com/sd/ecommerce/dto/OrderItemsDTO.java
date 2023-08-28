package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import com.sd.ecommerce.model.OrderDetails;
import com.sd.ecommerce.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {

    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    private OrderDetails orderDetails;
    private Product product;
    private int quantity;

}
