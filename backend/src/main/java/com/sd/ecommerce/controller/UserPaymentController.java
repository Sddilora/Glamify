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

import com.sd.ecommerce.dto.UserPaymentDTO;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

import com.sd.ecommerce.service.UserPaymentService;

@RestController
@RequestMapping("/userpayment")
@RequiredArgsConstructor
public class UserPaymentController {

    private final UserPaymentService userPaymentService;

    @PostMapping
    public ResponseEntity<Response> createUserPayment(@RequestBody @NotNull UserPaymentDTO userPaymentDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("userPayment", userPaymentService.save(userPaymentDTO)))
            .message("UserPayment created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping
    public ResponseEntity<Response> listUserPayments() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("userPayments", userPaymentService.list()))
        .message("UserPayments retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUserPayment(@PathVariable Long id) {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("userPayment", userPaymentService.get(id)))
        .message("UserPayment retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUserPayment(@PathVariable Long id, @RequestBody @NotNull UserPaymentDTO userPaymentDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("userPayment", userPaymentService.update(id, userPaymentDTO)))
            .message("UserPayment updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUserPayment(@PathVariable Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("userPayment", userPaymentService.delete(id)))
            .message("UserPayment deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
    
}
