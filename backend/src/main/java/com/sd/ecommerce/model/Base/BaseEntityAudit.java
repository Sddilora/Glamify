package com.sd.ecommerce.model.Base;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity{

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntityAudit)) return false;
        if (!super.equals(o)) return false;
        BaseEntityAudit that = (BaseEntityAudit) o;
        return  createdAt.equals(that.createdAt) && updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "BaseEntityAudit {" + "createdAt = " + createdAt + ", updatedAt = " + updatedAt + "}";
    }

    // for the child class to use id
    public BaseEntityAudit(Long id) {
        super(id);
    }

}
