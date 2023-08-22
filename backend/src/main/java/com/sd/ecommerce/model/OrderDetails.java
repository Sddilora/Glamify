package com.sd.ecommerce.model;

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
@Table(name = "order_details")
public class OrderDetails extends BaseEntity{

    @ManyToOne
    private User user;

    private float total;

    @OneToOne
    private PaymentDetails paymentDetails;

}
