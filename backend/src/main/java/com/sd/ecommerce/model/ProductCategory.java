package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.sd.ecommerce.enumeration.ProductCategories;
import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_category")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProductCategory extends SoftDeletableEntity{

    private ProductCategories name;
    private String description;
}
