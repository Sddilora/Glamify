package com.sd.ecommerce.dto;

import java.sql.Timestamp;

import com.sd.ecommerce.model.Discount;
import com.sd.ecommerce.model.ProductCategory;
import com.sd.ecommerce.model.ProductInventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    public ProductDTO(String name, double price, String photoUrl, String description, String sku, ProductCategory productCategory, ProductInventory productInventory, Discount discount) {
        this.name = name;
        this.price = price;
        this.photoUrl = photoUrl;
        this.description = description;
        this.sku = sku;
        this.productCategory = productCategory;
        this.productInventory = productInventory;
        this.discount = discount;
    }
    // BaseEntity
    private Long id;
    // BaseEntityAudit
    private Timestamp createdAt;
    private Timestamp updatedAt;
    // SoftDeletableEntity
    private Boolean deleted;

    private String name;
    private Double price;
    private String photoUrl;
    private String description;
    private String sku;
    private ProductCategory productCategory;
    private ProductInventory productInventory;
    private Discount discount;

}
