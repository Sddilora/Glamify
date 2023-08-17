package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntity;

@Entity
@Table(name = "order_details")
public class OrderDetails extends BaseEntity{

}
