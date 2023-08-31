package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import com.sd.ecommerce.enumeration.ProductCategories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {
    
    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;
    // SoftDeletableEntity
    private boolean deleted;
    
    private ProductCategories name;
    private String description;

}
