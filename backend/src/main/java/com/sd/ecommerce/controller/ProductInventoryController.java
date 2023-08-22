package com.sd.ecommerce.controller;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.ecommerce.model.ProductInventory;
import com.sd.ecommerce.service.implementation.ProductInventoryServiceImpl;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class ProductInventoryController {
    
    private final ProductInventoryServiceImpl productInventoryService;

    @PostMapping("/create")
    public ResponseEntity<Response> createProductInventory(@RequestBody @NotNull ProductInventory productInventory) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productInventory", productInventoryService.save(productInventory)))
            .message("Product Inventory created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listProductInventories() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("productInventories", productInventoryService.list()))
        .message("Product Inventories retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProductInventory(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productInventory", productInventoryService.get(id)))
            .message("Product Inventory retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateProductInventory(@NotNull Long id, @RequestBody @NotNull ProductInventory productInventory) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productInventory", productInventoryService.update(id, productInventory)))
            .message("Product Inventory updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProductInventory(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productInventory", productInventoryService.delete(id)))
            .message("Product Inventory deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
}
