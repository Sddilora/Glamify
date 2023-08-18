package com.sd.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.model.Response;
import com.sd.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;


@RestController // This means that this class is a Controller and will be used to create RESTful endpoints.
@RequestMapping("/product")
@RequiredArgsConstructor // This means that Spring will generate a constructor with all the required fields.
public class ProductController {
    
    private final ProductService productService;

    // public ProductController(ProductService productService) {
    //     this.productService = productService;
    // }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/list")
    public @NotNull Iterable<Product> getProducts() {
        return productService.list();
    }

    @GetMapping("/test")
    public ResponseEntity<Response> test() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("products", productService.list()))
        .message("Products retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
}
}
