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

import com.sd.ecommerce.util.Response;
import com.sd.ecommerce.dto.DiscountDTO;
import com.sd.ecommerce.service.DiscountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping
    public ResponseEntity<Response> createDiscount(@RequestBody @NotNull DiscountDTO discountDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("discount", discountService.save(discountDTO)))
            .message("Discount created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping
    public ResponseEntity<Response> listDiscounts() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("discounts", discountService.list()))
        .message("Discounts retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getDiscount(@PathVariable Long id) {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("discount", discountService.get(id)))
        .message("Discount retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateDiscount(@PathVariable Long id, @RequestBody @NotNull DiscountDTO discountDTO) {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("discount", discountService.update(id, discountDTO)))
        .message("Discount updated")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDiscount(@PathVariable Long id) {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("discount", discountService.delete(id)))
        .message("Discount deleted")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }
    
}
