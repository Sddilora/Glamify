package com.sd.ecommerce.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.ProductDTO;
import com.sd.ecommerce.dto.Mapper.ProductMapper;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO save(ProductDTO productDTO) {
        log.info("Saving new Product {} to the database", productDTO.getName());
        return productMapper.convertToDTO(productRepository.save(productMapper.convertToEntity(productDTO)));
    }

    public ProductDTO get(Long id) {
        log.info("Fetching Product {}", id);
        return productMapper.convertToDTO(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with provided ID not found")));
    }

    public List<ProductDTO> list() {
        log.info("Fetching all Products");
        return productMapper.convertToDTO((List<Product>) productRepository.findAll());
    }


    public ProductDTO update(Long id, ProductDTO productDTO) {
        log.info("Updating Product {}", id);
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with provided ID not found"));
        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setPhotoUrl(productDTO.getPhotoUrl());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setSku(productDTO.getSku());
        existingProduct.setProductCategory(productDTO.getProductCategory());
        existingProduct.setProductInventory(productDTO.getProductInventory());
        existingProduct.setDiscount(productDTO.getDiscount());
        return productMapper.convertToDTO(productRepository.save(existingProduct));

    }

    public ProductDTO delete(Long id) {
        log.info("Deleting Product {}", id);
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with provided ID not found"));
        productRepository.deleteById(id);
        return productMapper.convertToDTO(existingProduct);
    }

}