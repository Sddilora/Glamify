package com.sd.ecommerce.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.ProductInventory;
import com.sd.ecommerce.repository.ProductInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ProductInventoryService{
    
    private final ProductInventoryRepository productInventoryRepository;

    public ProductInventory save(ProductInventory productInventory) {
        log.info("Saving new ProductInventory {} to the database", productInventory.getId());
        return productInventoryRepository.save(productInventory);
    }

    public ProductInventory get(Long id) {
        log.info("Fetching ProductInventory {}", id);
        return productInventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Inventory not found"));
    }

    public ProductInventory update(Long id, ProductInventory productInventory) {
        log.info("Updating ProductInventory {} with {}", id, productInventory.toString());
        ProductInventory existingProductInventory = productInventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Inventory not found"));
        existingProductInventory.setQuantity(productInventory.getQuantity());
        return productInventoryRepository.save(existingProductInventory);
    }

    public ProductInventory delete(Long id) {
        log.info("Deleting ProductInventory {}", id);
        ProductInventory existingProductInventory = productInventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Inventory not found"));
        productInventoryRepository.deleteById(id);
        return existingProductInventory;
    }

    public Collection<ProductInventory> list() {
        log.info("Fetching all Product Inventories");
        return (Collection<ProductInventory>) productInventoryRepository.findAll();
    }
}
