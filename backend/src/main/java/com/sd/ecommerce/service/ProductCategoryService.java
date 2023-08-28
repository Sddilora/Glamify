package com.sd.ecommerce.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.ProductCategoryDTO;
import com.sd.ecommerce.dto.Mapper.ProductCategoryMapper;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.ProductCategory;
import com.sd.ecommerce.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ProductCategoryService{

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO) {
        log.info("Saving new ProductCategory {} to the database", productCategoryDTO.getName());
        return productCategoryMapper.convertToDTO(productCategoryRepository.save(productCategoryMapper.convertToEntity(productCategoryDTO)));
    }

    public ProductCategoryDTO get(Long id) {
        log.info("Fetching ProductCategory {}", id);
        return productCategoryMapper.convertToDTO(productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory with provided ID not found")));
    }

    public List<ProductCategoryDTO> list() {
        log.info("Fetching all ProductCategorys");
        return productCategoryMapper.convertToDTO((List<ProductCategory>) productCategoryRepository.findAll());
    }

    public ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO) {
        log.info("Updating ProductCategory {}", id);
        ProductCategory existingProductCategory = productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory with provided ID not found"));
        existingProductCategory.setName(productCategoryDTO.getName());
        existingProductCategory.setDescription(productCategoryDTO.getDescription());
        return productCategoryMapper.convertToDTO(productCategoryRepository.save(existingProductCategory));

    }

    public ProductCategoryDTO delete(Long id) {
        log.info("Deleting ProductCategory {}", id);
        ProductCategory existingProductCategory = productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductCategory with provided ID not found"));
        productCategoryRepository.deleteById(id);
        return productCategoryMapper.convertToDTO(existingProductCategory);
    }
}