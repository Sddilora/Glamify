package com.sd.ecommerce.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class Product extends SoftDeletableEntity {

    @NotNull(message = "Product name is required.")
    @Basic(optional = false) // This is a required field
    private String name;
    
    private Double price;

    private String photoUrl;

    private String description;

    public Product(Long id, @NotNull(message = "Product name is required.") String name, double price, String photoUrl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photoUrl = photoUrl;
        this.description = description;
    }

    // This is required for the @Data annotation to work
    public Product() {
    }

    // private String sku; // Stock Keeping Unit

    // private long categoryId;

    // private long inventoryId;

    // private long discountId;
}
