package com.sd.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.ProductInventoryDTO;
import com.sd.ecommerce.dto.Mapper.ProductInventoryMapper;
import com.sd.ecommerce.model.ProductInventory;
import com.sd.ecommerce.repository.ProductInventoryRepository;
import com.sd.ecommerce.util.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ProductInventoryService{
    
    private final ProductInventoryRepository productInventoryRepository;
    private final ProductInventoryMapper productInventoryMapper;

    public ProductInventoryDTO save(ProductInventoryDTO productInventoryDTO) {
        log.info("Saving new ProductInventory {} to the database", productInventoryDTO.getId());
        return productInventoryMapper.convertToDTO(productInventoryRepository.save(productInventoryMapper.convertToEntity(productInventoryDTO)));
    }

    public ProductInventoryDTO get(Long id) {
        log.info("Fetching ProductInventory {}", id);
        return productInventoryMapper.convertToDTO(productInventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductInventory with provided ID not found")));
    }

    public List<ProductInventoryDTO> list() {
        log.info("Fetching all ProductInventorys");
        return productInventoryMapper.convertToDTO((List<ProductInventory>) productInventoryRepository.findAll());
    }

    public ProductInventoryDTO update(Long id, ProductInventoryDTO productInventoryDTO) {
        log.info("Updating ProductInventory {}", id);
        ProductInventory existingProductInventory = productInventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductInventory with provided ID not found"));
        existingProductInventory.setDeleted(productInventoryDTO.isDeleted());
        existingProductInventory.setQuantity(productInventoryDTO.getQuantity());
        return productInventoryMapper.convertToDTO(productInventoryRepository.save(existingProductInventory));

    }

    public ProductInventoryDTO delete(Long id) {
        log.info("Deleting ProductInventory {}", id);
        ProductInventory existingProductInventory = productInventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductInventory with provided ID not found"));
        productInventoryRepository.deleteById(id);
        return productInventoryMapper.convertToDTO(existingProductInventory);
    }
}
