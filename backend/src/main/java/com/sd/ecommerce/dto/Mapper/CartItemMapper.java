package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.CartItemDTO;
import com.sd.ecommerce.model.CartItem;

@Component
public class CartItemMapper {
    
    public CartItem convertToEntity(CartItemDTO cartItemDTO) {
        CartItem cartItem = new CartItem();
        cartItem.setId(cartItemDTO.getId()); // TODO - is this needed?
        cartItem.setProduct(cartItemDTO.getProduct());
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setShoppingSession(cartItemDTO.getShoppingSession());
        return cartItem;
    }

    public CartItemDTO convertToDTO(CartItem cartItem) {
        return new CartItemDTO(cartItem.getId(), cartItem.getCreatedAt(), cartItem.getUpdatedAt(), cartItem.getShoppingSession(), cartItem.getProduct(), cartItem.getQuantity());
    }

    public List<CartItemDTO> convertToDTO(List<CartItem> cartItems) {
        return cartItems.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
}
