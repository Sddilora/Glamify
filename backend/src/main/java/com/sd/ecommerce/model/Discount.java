package com.sd.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.sd.ecommerce.model.Base.SoftDeletableEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Discount extends SoftDeletableEntity{

    private String name;
    private String description;
    private float discount_percent;
    private boolean isActive;

    // public boolean get_active(){
    //     return is_active;
    // }

}
