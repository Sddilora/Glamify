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
@Table(name = "payment_details")
public class PaymentDetails extends BaseEntity{

    @OneToOne
    private OrderDetails orderDetails;

    private int amount;

    private String provider;

    private String status;

}
