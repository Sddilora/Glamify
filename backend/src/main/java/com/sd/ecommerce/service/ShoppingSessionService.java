package com.sd.ecommerce.service;

import com.sd.ecommerce.repository.ShoppingSessionRepository;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.ShoppingSessionDTO;
import com.sd.ecommerce.dto.Mapper.ShoppingSessionMapper;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.ShoppingSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ShoppingSessionService{
    
    private final ShoppingSessionRepository shoppingSessionRepository;
    private final ShoppingSessionMapper shoppingSessionMapper;

    public ShoppingSessionDTO save(ShoppingSessionDTO shoppingSessionDTO) {
        log.info("Saving new ShoppingSession whisch is belong to {} to the database", shoppingSessionDTO.getUser().getUserName());
        return shoppingSessionMapper.convertToDTO(shoppingSessionRepository.save(shoppingSessionMapper.convertToEntity(shoppingSessionDTO)));
    }

    public ShoppingSessionDTO get(Long id) {
        log.info("Fetching ShoppingSession {}", id);
        return shoppingSessionMapper.convertToDTO(shoppingSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShoppingSession with provided ID not found")));
    }

    public List<ShoppingSessionDTO> list() {
        log.info("Fetching all ShoppingSessions");
        return shoppingSessionMapper.convertToDTO((List<ShoppingSession>) shoppingSessionRepository.findAll());
    }
    
    public ShoppingSessionDTO update(Long id, ShoppingSessionDTO shoppingSessionDTO) {
        log.info("Updating ShoppingSession {}", id);
        ShoppingSession existingShoppingSession = shoppingSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShoppingSession with provided ID not found"));
        existingShoppingSession.setUser(shoppingSessionDTO.getUser());
        existingShoppingSession.setTotal(shoppingSessionDTO.getTotal());
        return shoppingSessionMapper.convertToDTO(shoppingSessionRepository.save(existingShoppingSession));
    }

    public ShoppingSessionDTO delete(Long id) {
        log.info("Deleting ShoppingSession {}", id);
        ShoppingSession existingShoppingSession = shoppingSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShoppingSession with provided ID not found"));
        shoppingSessionRepository.deleteById(id);
        return shoppingSessionMapper.convertToDTO(existingShoppingSession);
    }
}
