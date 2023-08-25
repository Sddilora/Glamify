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

import com.sd.ecommerce.dto.ProductDTO;
import com.sd.ecommerce.dto.Mapper.ProductMapper;
import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.service.ProductService;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;


@RestController // This means that this class is a Controller and will be used to create RESTful endpoints.
@RequestMapping("/product")
@RequiredArgsConstructor // This means that Spring will generate a constructor with all the required fields.
public class ProductController {
    
    private final ProductService productService;
    private final ProductMapper ProductMapper;

    @PostMapping("/create")
    public ResponseEntity<Response> createProduct(@RequestBody @NotNull ProductDTO ProductDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("product", ProductMapper.convertToDTO(productService.save(ProductMapper.convertToEntity(ProductDTO)))))
            .message("Product created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listProducts() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("products", ProductMapper.convertToDTO(productService.list())))
        .message("Products retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("product", ProductMapper.convertToDTO(productService.get(id))))
            .message("Product retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateProduct(@PathVariable Long id, @RequestBody ProductDTO ProductDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("product", ProductMapper.convertToDTO(productService.update(id, ProductMapper.convertToEntity(ProductDTO)))))
            .message("Product updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("product", ProductMapper.convertToDTO(productService.delete(id))))
            .message("Product deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
}
