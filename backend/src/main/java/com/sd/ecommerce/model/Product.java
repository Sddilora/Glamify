package com.sd.ecommerce.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
// @EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor // This is a default (no-argument) constructor that initializes the object. It calls the constructor of the superclass (SoftDeletableEntity) using super(), which is important for proper inheritance. But we don't need this constructor because we have another constructor with all parameters. Which is @Data annotation.
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Product extends SoftDeletableEntity {

    @NotNull(message = "Product name is required.")
    @Basic(optional = false) // This is a required field
    private String name;
    
    private Double price;

    private String photoUrl;

    private String description;

    // private String sku; // Stock Keeping Unit

    // Category_id is coming from the ProductCategory table. So we nood to add the relationship between Product and ProductCategory.
    // @JoinColumn(name = "category_id") // This is the foreign key
    @ManyToOne // One product can have one category. But one category can have many products.
    private ProductCategory categoryId;

    // private long inventoryId;

    // private long discountId;

    public Product(@NotNull(message = "Product name is required.") String name, double price, String photoUrl, String description, ProductCategory categoryId) {
        this.name = name;
        this.price = price;
        this.photoUrl = photoUrl;
        this.description = description;
        this.categoryId = categoryId;
    }
}
