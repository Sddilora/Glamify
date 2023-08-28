package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.ProductCategoryDTO;
import com.sd.ecommerce.model.ProductCategory;

@Component
public class ProductCategoryMapper {

    public ProductCategory convertToEntity(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDTO.getId());
        productCategory.setDeleted(productCategoryDTO.isDeleted());
        productCategory.setName(productCategoryDTO.getName());
        productCategory.setDescription(productCategoryDTO.getDescription());
        return productCategory;
    }

    public ProductCategoryDTO convertToDTO(ProductCategory productCategory) {
        return new ProductCategoryDTO(productCategory.getId(), productCategory.getCreatedAt(), productCategory.getUpdatedAt(), productCategory.isDeleted(), productCategory.getName(), productCategory.getDescription());
    }

    public List<ProductCategoryDTO> convertToDTO(List<ProductCategory> productCategories) {
        return productCategories.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
}
