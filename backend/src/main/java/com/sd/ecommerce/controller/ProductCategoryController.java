package com.sd.ecommerce.controller;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.ecommerce.dto.ProductCategoryDTO;
import com.sd.ecommerce.service.ProductCategoryService;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class ProductCategoryController {
    
    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<Response> createProductCategory(@RequestBody @NotNull ProductCategoryDTO productCategoryDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.save(productCategoryDTO)))
            .message("Product Category created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping
    public ResponseEntity<Response> listProductCategories() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("productCategories", productCategoryService.list()))
        .message("Product Categories retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getProductCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.get(id)))
            .message("Product Category retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateProductCategory(@PathVariable("id") Long id, @RequestBody @NotNull ProductCategoryDTO productCategoryDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.update(id, productCategoryDTO)))
            .message("Product Category updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProductCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.delete(id)))
            .message("Product Category deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
}
