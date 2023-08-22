package com.sd.ecommerce.service.implementation;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.repository.ProductRepository;
import com.sd.ecommerce.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ProductServiceImpl implements BaseService<Product> {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        log.info("Saving new Product {} to the database", product.getName());
        return productRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        log.info("Fetching Product {}", id);
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product update(Long id, Product product) {
        log.info("Updating Product {} with {}", id, product.toString());
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPhotoUrl(product.getPhotoUrl());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategoryId(product.getCategoryId());
        existingProduct.setInventoryId(product.getInventoryId());
        existingProduct.setDiscountId(product.getDiscountId());
        return productRepository.save(existingProduct);
    }

    @Override
    public Product delete(Long id) {
        log.info("Deleting Product {}", id);
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.deleteById(id);
        return existingProduct;
    }

    @Override
    public Collection<Product> list() {
        log.info("Fetching all Products");
        return (Collection<Product>) productRepository.findAll();
    }


}