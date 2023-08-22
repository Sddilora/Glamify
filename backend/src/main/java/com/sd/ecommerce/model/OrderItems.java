package com.sd.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntity;

@Entity
@Table(name = "order_items")
public class OrderItems extends BaseEntity{

    @ManyToOne
    private OrderDetails orderDetails;

    @OneToOne // This is a one to one relationship. One order item can have only one product. ?
    private Product product;

    private int quantity;
    
}
