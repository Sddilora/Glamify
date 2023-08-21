package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_inventory")
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory extends SoftDeletableEntity{

    // quantity
    private int quantity;

}
