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

import com.sd.ecommerce.model.ShoppingSession;
import com.sd.ecommerce.service.implementation.ShoppingSessionServiceImpl;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shopping-session")
@RequiredArgsConstructor
public class ShoppingSessionController {
    
    private final ShoppingSessionServiceImpl shoppingSessionService;

    @PostMapping("/create")
    public ResponseEntity<Response> createShoppingSession(@RequestBody @NotNull ShoppingSession shoppingSession) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("shoppingSession", shoppingSessionService.save(shoppingSession)))
            .message("Shopping Session created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listShoppingSessions() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("shoppingSessions", shoppingSessionService.list()))
        .message("Shopping Sessions retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getShoppingSession(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("shoppingSession", shoppingSessionService.get(id)))
            .message("Shopping Session retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateShoppingSession(@NotNull Long id, @RequestBody @NotNull ShoppingSession shoppingSession) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("shoppingSession", shoppingSessionService.update(id, shoppingSession)))
            .message("Shopping Session updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteShoppingSession(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("shoppingSession", shoppingSessionService.delete(id)))
            .message("Shopping Session deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

}
