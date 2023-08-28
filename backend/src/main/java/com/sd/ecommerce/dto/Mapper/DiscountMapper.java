package com.sd.ecommerce.dto.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.DiscountDTO;
import com.sd.ecommerce.model.Discount;

@Component
public class DiscountMapper {

    public Discount convertToEntity(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        discount.setId(discountDTO.getId()); // TODO - is this needed?
        discount.setName(discountDTO.getName());
        discount.setDescription(discountDTO.getDescription());
        discount.setDiscount_percent(discountDTO.getDiscount_percent());
        discount.setActive(discountDTO.isActive());
        return discount;
    }

    public DiscountDTO convertToDTO(Discount discount) {
        return new DiscountDTO(discount.getId(), discount.getCreatedAt(), discount.getUpdatedAt(),discount.isDeleted(), discount.getName(), discount.getDescription(), discount.getDiscount_percent(), discount.isActive());
    }

    public List<DiscountDTO> convertToDTO(List<Discount> discounts) {
        return discounts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
}
