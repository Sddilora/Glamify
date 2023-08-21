package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
public class Discount extends SoftDeletableEntity{

    private String name;
    private String description;
    private float discount_percent;
    private boolean is_active;

    // public Discount(String name, String description, int percentage, boolean is_active) {
    //     this.name = name;
    //     this.description = description;
    //     this.discount_percent = percentage;
    //     this.is_active = is_active;
    // }

}
