package com.sd.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.CartItemDTO;
import com.sd.ecommerce.dto.Mapper.CartItemMapper;
import com.sd.ecommerce.model.CartItem;
import com.sd.ecommerce.repository.CartItemRepository;
import com.sd.ecommerce.util.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    public CartItemDTO save(CartItemDTO cartItemDTO) {
        log.info("Saving new CartItem {} to the database", cartItemDTO.getId());
        return cartItemMapper.convertToDTO(cartItemRepository.save(cartItemMapper.convertToEntity(cartItemDTO)));
    }
    
    public CartItemDTO get(Long id) {
        log.info("Fetching CartItem {}", id);
        return cartItemMapper.convertToDTO(cartItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CartItem with provided ID not found")));
    }

    public List<CartItemDTO> list() {
        log.info("Fetching all CartItems");
        return cartItemMapper.convertToDTO((List<CartItem>) cartItemRepository.findAll());
    }


    public CartItemDTO update(Long id, CartItemDTO cartItemDTO) {
        log.info("Updating CartItem {}", cartItemDTO.getProduct());
        CartItem existingCartItem = cartItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CartItem with provided ID not found"));
        existingCartItem.setQuantity(cartItemDTO.getQuantity());
        existingCartItem.setProduct(cartItemDTO.getProduct());
        existingCartItem.setShoppingSession(cartItemDTO.getShoppingSession());
        return cartItemMapper.convertToDTO(cartItemRepository.save(existingCartItem));

    }

    public CartItemDTO delete(Long id) {
        log.info("Deleting CartItem {}", id);
        CartItem existingCartItem = cartItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CartItem with provided ID not found"));
        cartItemRepository.deleteById(id);
        return cartItemMapper.convertToDTO(existingCartItem);
    }
}
