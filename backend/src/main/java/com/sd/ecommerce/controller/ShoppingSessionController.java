package com.sd.ecommerce.controller;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.ecommerce.dto.ShoppingSessionDTO;
import com.sd.ecommerce.model.User;
import com.sd.ecommerce.repository.UserRepository;
import com.sd.ecommerce.service.ShoppingSessionService;
import com.sd.ecommerce.util.Response;
import com.sd.ecommerce.util.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shoppingsession")
@RequiredArgsConstructor
public class ShoppingSessionController {
    
    private final ShoppingSessionService shoppingSessionService;
    private final UserRepository UserRepository;

    @PostMapping
    public ResponseEntity<Response> createShoppingSession(@RequestBody ShoppingSessionDTO shoppingSessionDTO) {
        
        Long userId = shoppingSessionDTO.getUser().getId();

        if (userId == null) {
            return ResponseEntity.badRequest().body(
                Response.builder()
                    .timeStamp(now())
                    .message("User ID is required for creating a Shopping Session")
                    .status(HttpStatus.BAD_REQUEST)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build()
            );
        }

        User user = UserRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with provided ID not found"));
        
        ShoppingSessionDTO newShoppingSessionDTO = new ShoppingSessionDTO();
        newShoppingSessionDTO.setUser(user);
        newShoppingSessionDTO.setTotal(shoppingSessionDTO.getTotal());

        ShoppingSessionDTO createdSession = shoppingSessionService.save(newShoppingSessionDTO);

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(Map.of("shoppingSession", createdSession))
                .message("Shopping Session created")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build()
        );
    }


    @GetMapping
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

    @GetMapping("/{id}")
    public ResponseEntity<Response> getShoppingSession(@PathVariable("id") Long id) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateShoppingSession(@PathVariable("id") Long id, @RequestBody @NotNull ShoppingSessionDTO shoppingSessionDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("shoppingSession", shoppingSessionService.update(id, shoppingSessionDTO)))
            .message("Shopping Session updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteShoppingSession(@PathVariable("id") Long id) {
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
