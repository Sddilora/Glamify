package com.sd.ecommerce.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_category")
@NoArgsConstructor
public class ProductCategory extends SoftDeletableEntity{

    private String name;
    private String description;

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    } 

    @OneToMany(mappedBy = "categoryId")
    private Collection<Product> product;

}
