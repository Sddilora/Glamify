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

import com.sd.ecommerce.dto.ProductInventoryDTO;
import com.sd.ecommerce.service.ProductInventoryService;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class ProductInventoryController {
    
    private final ProductInventoryService productInventoryService;

    @PostMapping
    public ResponseEntity<Response> createProductInventory(@RequestBody @NotNull ProductInventoryDTO productInventoryDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productInventory", productInventoryService.save(productInventoryDTO)))
            .message("Product Inventory created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping
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
    
    @GetMapping("/{id}")
    public ResponseEntity<Response> getProductInventory(@PathVariable("id") Long id) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateProductInventory(@PathVariable("id") Long id, @RequestBody @NotNull ProductInventoryDTO productInventoryDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productInventory", productInventoryService.update(id, productInventoryDTO)))
            .message("Product Inventory updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProductInventory(@PathVariable("id") Long id) {
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
