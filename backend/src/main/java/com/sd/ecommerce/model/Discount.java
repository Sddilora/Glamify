package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "discount")
@NoArgsConstructor
public class Discount extends SoftDeletableEntity{

    private String name;
    private String description;
    private float discount_percent;
    private boolean is_active;

    // // No-argument constructor
    // public Discount() {
    //     super();
    // }

    // // Constructor with id parameter ( This constructor takes an id parameter and passes it to the superclass constructor. It seems to be used when creating a new Discount object with just an ID. or when we want to delete or update a Discount object.)
    // public Discount(Long id) {
    //     super(id); // super is used to call the constructor of the superclass. In this case, the superclass is SoftDeletableEntity.
    // }

    // Constructor with all parameters
    // Since my id's are auto-generated, I don't need to pass the id parameter to the constructor.
    public Discount(String name, String description, int percentage, boolean is_active) {
        this.name = name;
        this.description = description;
        this.discount_percent = percentage;
        this.is_active = is_active;
    }

}
