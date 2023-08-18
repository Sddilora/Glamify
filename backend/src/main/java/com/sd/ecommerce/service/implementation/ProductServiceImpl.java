package com.sd.ecommerce.service.implementation;

import java.util.Collection;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.repository.ProductRepository;
import com.sd.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        log.info("Saving new Product {} to the database", product.getName());
        return productRepository.save(product);
    }

    @Override
    public Product get(long id) {
        log.info("Fetching Product {}", id);
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product update(long id, Product product) {
        log.info("Updating Product {} with {}", id, product);
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPhotoUrl(product.getPhotoUrl());
        existingProduct.setDescription(product.getDescription());
        return productRepository.save(existingProduct);
    }

    @Override
    public Product delete(long id) {
        log.info("Deleting Product {}", id);
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(existingProduct);
        return existingProduct;
    }

    @Override
    public Collection<Product> list() {
        log.info("Fetching all Products");
        return (Collection<Product>) productRepository.findAll();
    }


}

//// Ex version
    // private ProductRepository productRepository;

    // @Autowired // This annotation tells Spring to inject an instance of ProductRepository here. This is called dependency injection.
    // public ProductServiceImpl(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    // @Override
    // public Iterable<Product> getAllProducts() {
    //     return productRepository.findAll();
    // }

    // @Override
    // public Product getProduct(long id) {
    //     return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    // }

    // @Override
    // public Product save(Product product) {
    //     return productRepository.save(product);
    // }