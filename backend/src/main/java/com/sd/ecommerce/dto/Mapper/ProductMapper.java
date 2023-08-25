package com.sd.ecommerce.dto.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.ProductDTO;
import com.sd.ecommerce.model.Product;

@Component
public class ProductMapper {
    
    // Conversion method from ProductDTO to Product entity
    public Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setPhotoUrl(productDTO.getPhotoUrl());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setCategoryId(productDTO.getCategoryId());
        product.setInventoryId(productDTO.getInventoryId());
        product.setDiscountId(productDTO.getDiscountId());
        return product;
    }

    // Conversion method from Product entity to ProductDTO
    public ProductDTO convertToDTO(Product product) {
        return new ProductDTO(product.getName(), product.getPrice(), product.getPhotoUrl(), product.getDescription(), product.getSku(), product.getCategoryId(), product.getInventoryId(), product.getDiscountId());
    }

    public List<ProductDTO> convertToDTO(Collection<Product> products) {
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
