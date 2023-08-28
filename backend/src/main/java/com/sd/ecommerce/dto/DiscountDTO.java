package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {

    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;
    // SoftDeletableEntity
    private Boolean deleted;
    
    private String name;
    private String description;
    private float discount_percent;
    private boolean isActive;
    
}
