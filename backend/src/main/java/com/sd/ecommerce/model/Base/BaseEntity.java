package com.sd.ecommerce.model.Base;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// java.io.Serializable is used to convert the object into a byte stream. It is mainly used to travel the object's state on the network (that is known as marshaling). It is also used to persist the object's state in the database or to save it in a file.
public abstract class BaseEntity implements Serializable {

    @Id //The id is annotated with @Id, which marks it as the primary key to identify this entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    // The difference between GenerationType.IDENTITY and GenerationType.AUTO is that the first one is for databases that support auto-increment columns, and the second one is for databases that don't support auto-increment columns.
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BaseEntity {" + "id = " + id + "}";
    }
}
