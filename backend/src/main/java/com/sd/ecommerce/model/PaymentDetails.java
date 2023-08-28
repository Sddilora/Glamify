package com.sd.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntityAudit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment_details")
public class PaymentDetails extends BaseEntityAudit{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_details_id", referencedColumnName = "id")
    private OrderDetails orderDetails;

    private int amount;

    private String provider;

    private String status;

}
