package com.sd.ecommerce.model.Base;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// @Data
// @NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // to avoid the error: java.lang.StackOverflowError: null 
@Getter
@Setter
@MappedSuperclass
@SQLDelete(sql = "UPDATE ${table} SET deleted_at=now() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class SoftDeletableEntity extends BaseEntityAudit  implements Serializable{

    @Column(name = "deleted_at")
    private Timestamp deletedAt;
}

// Soft deletion is needed to keep the data integrity and to keep the data history.
// Soft deletion is a way to mark the data as deleted instead of actually deleting it.
// In the extends of this classes, we have to add the table name. (@Table(name = "car"))