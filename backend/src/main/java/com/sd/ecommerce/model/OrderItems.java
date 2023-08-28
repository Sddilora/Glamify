package com.sd.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntityAudit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItems extends BaseEntityAudit{

    @ManyToOne
    private OrderDetails orderDetails;

    @OneToOne(cascade = CascadeType.ALL) // This is a one to one relationship. One order item can have only one product. ?
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private int quantity;
    
}
