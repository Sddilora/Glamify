package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

@Entity
@Table(name = "discount")
public class Discount extends SoftDeletableEntity{

}
