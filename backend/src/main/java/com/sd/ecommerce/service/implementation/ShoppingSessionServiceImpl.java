package com.sd.ecommerce.service.implementation;

import com.sd.ecommerce.repository.ShoppingSessionRepository;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.ShoppingSession;
import com.sd.ecommerce.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ShoppingSessionServiceImpl implements BaseService<ShoppingSession>{
    
    private final ShoppingSessionRepository shoppingSessionRepository;

    @Override
    public ShoppingSession save(ShoppingSession shoppingSession) {
        log.info("Saving new ShoppingSession {} to the database", shoppingSession.getId());
        return shoppingSessionRepository.save(shoppingSession);
    }

    @Override
    public ShoppingSession get(Long id) {
        log.info("Fetching ShoppingSession {}", id);
        return shoppingSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShoppingSession not found"));
    }

    @Override
    public ShoppingSession update(Long id, ShoppingSession shoppingSession) {
        log.info("Updating ShoppingSession {} with {}", id, shoppingSession.toString());
        ShoppingSession existingShoppingSession = shoppingSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShoppingSession not found"));
        existingShoppingSession.setTotal(shoppingSession.getTotal());
        existingShoppingSession.setUser(shoppingSession.getUser());
        return shoppingSessionRepository.save(existingShoppingSession);
    }

    @Override
    public ShoppingSession delete(Long id) {
        log.info("Deleting ShoppingSession {}", id);
        ShoppingSession existingShoppingSession = shoppingSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShoppingSession not found"));
        shoppingSessionRepository.deleteById(id);
        return existingShoppingSession;
    }

    @Override
    public Collection<ShoppingSession> list() {
        log.info("Fetching all ShoppingSessions");
        return (Collection<ShoppingSession>) shoppingSessionRepository.findAll();
    }
}
