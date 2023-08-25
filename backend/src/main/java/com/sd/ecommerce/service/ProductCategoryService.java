package com.sd.ecommerce.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ProductCategory save(ProductCategory productCategory) {
        log.info("Saving new ProductCategory {} to the database", productCategory.getName());
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory get(Long id) {
        log.info("Fetching ProductCategory {}", id);
        return productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Category not found"));
    }

    public ProductCategory update(Long id, ProductCategory productCategory) {
        log.info("Updating ProductCategory {} with {}", id, productCategory.toString());
        ProductCategory existingProductCategory = productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Category not found"));
        existingProductCategory.setName(productCategory.getName());
        existingProductCategory.setDescription(productCategory.getDescription());
        return productCategoryRepository.save(existingProductCategory);
    }

    public ProductCategory delete(Long id) {
        log.info("Deleting ProductCategory {}", id);
        ProductCategory existingProductCategory = productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Category not found"));
        productCategoryRepository.deleteById(id);
        return existingProductCategory;
    }

    public Collection<ProductCategory> list() {
        log.info("Fetching all Product Categories");
        return (Collection<ProductCategory>) productCategoryRepository.findAll();
    }
}
 