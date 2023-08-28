package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.ProductInventoryDTO;
import com.sd.ecommerce.model.ProductInventory;

@Component
public class ProductInventoryMapper {

    public ProductInventory convertToEntity(ProductInventoryDTO productInventoryDTO) {
        ProductInventory productInventory = new ProductInventory();
        productInventory.setId(productInventoryDTO.getId());
        productInventory.setDeleted(productInventoryDTO.isDeleted());
        productInventory.setQuantity(productInventoryDTO.getQuantity());
        return productInventory;
    }

    public ProductInventoryDTO convertToDTO(ProductInventory productInventory) {
        return new ProductInventoryDTO(productInventory.getId(), productInventory.getCreatedAt(), productInventory.getUpdatedAt(), productInventory.isDeleted(), productInventory.getQuantity());
    }

    public List<ProductInventoryDTO> convertToDTO(List<ProductInventory> productInventories) {
        return productInventories.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
}
