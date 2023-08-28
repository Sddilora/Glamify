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

import com.sd.ecommerce.dto.CartItemDTO;
import com.sd.ecommerce.service.CartItemService;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cartitem")
@RequiredArgsConstructor
public class CartItemControler {

    private final CartItemService cartItemService;
    @PostMapping
    public ResponseEntity<Response> createCartItem(@RequestBody @NotNull CartItemDTO cartItemDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("cartItem", cartItemService.save(cartItemDTO)))
            .message("CartItem created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
    
    @GetMapping
    public ResponseEntity<Response> listCartItems() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("cartItems", cartItemService.list()))
        .message("CartItems retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getCartItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("cartItem", cartItemService.get(id)))
            .message("CartItem retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateCartItem(@PathVariable Long id, @RequestBody CartItemDTO cartItemDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("cartItem", cartItemService.update(id, cartItemDTO)))
            .message("CartItem updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCartItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("cartItem", cartItemService.delete(id)))
            .message("CartItem deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
}
