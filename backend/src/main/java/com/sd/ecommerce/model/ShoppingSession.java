package com.sd.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shopping_session")
public class ShoppingSession extends BaseEntity{

    @OneToOne
    private User user;

    private float total;
}
