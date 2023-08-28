package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.model.ShoppingSession;
import com.sd.ecommerce.dto.ShoppingSessionDTO;

@Component
public class ShoppingSessionMapper {

    public ShoppingSession convertToEntity(ShoppingSessionDTO shoppingSessionDTO) {
        ShoppingSession shoppingSession = new ShoppingSession();
        shoppingSession.setId(shoppingSessionDTO.getId());
        shoppingSession.setUser(shoppingSessionDTO.getUser());
        shoppingSession.setTotal(shoppingSessionDTO.getTotal());
        return shoppingSession;
    }

    public ShoppingSessionDTO convertToDTO(ShoppingSession shoppingSession) {
        return new ShoppingSessionDTO(shoppingSession.getId(), shoppingSession.getCreatedAt(), shoppingSession.getUpdatedAt(), shoppingSession.getUser(), shoppingSession.getTotal());
    }

    public List<ShoppingSessionDTO> convertToDTO(List<ShoppingSession> shoppingSessions) {
        return shoppingSessions.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
    
}
