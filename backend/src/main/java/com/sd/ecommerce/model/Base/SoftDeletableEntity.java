package com.sd.ecommerce.model.Base;

import javax.persistence.MappedSuperclass;

import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// @Data
// @NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // to avoid the error: java.lang.StackOverflowError: null 
@Getter
@Setter
@MappedSuperclass
public class SoftDeletableEntity extends BaseEntityAudit{

    private boolean deleted = Boolean.FALSE;
}

// Soft deletion is needed to keep the data integrity and to keep the data history.
// Soft deletion is a way to mark the data as deleted instead of actually deleting it.
// In the extends of this classes, we have to add the table name. (@Table(name = "car"))