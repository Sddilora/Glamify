package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sd.ecommerce.model.Base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity{
}
