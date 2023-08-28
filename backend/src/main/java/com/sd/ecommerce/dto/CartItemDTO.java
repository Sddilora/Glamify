package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.model.ShoppingSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private ShoppingSession shoppingSession;
    private Product product;
    private int quantity;
}
