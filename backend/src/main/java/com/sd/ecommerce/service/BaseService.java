package com.sd.ecommerce.service;

import java.util.Collection;

public interface BaseService <T> {

        T save(T t);
        
        T get(Long id); // Optional is a container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
        
        T update(Long id, T t);
        
        T delete(Long id);
        
        Collection<T> list();
}
