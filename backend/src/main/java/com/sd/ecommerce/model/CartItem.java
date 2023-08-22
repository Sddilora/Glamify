package com.sd.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity{

    @ManyToOne
    private ShoppingSession shoppingSession;

    @OneToOne
    private Product product;

    private int quantity;
}
