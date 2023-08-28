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

import com.sd.ecommerce.dto.PaymentDetailsDTO;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;
import com.sd.ecommerce.service.PaymentDetailsService;

@RestController
@RequestMapping("/paymentdetails")
@RequiredArgsConstructor
public class PaymentDetailsController {

    private final PaymentDetailsService paymentDetailsService;

    @PostMapping
    public ResponseEntity<Response> createPaymentDetails(@RequestBody @NotNull PaymentDetailsDTO paymentDetailsDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("paymentDetails", paymentDetailsService.save(paymentDetailsDTO)))
            .message("PaymentDetails created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping
    public ResponseEntity<Response> listPaymentDetailss() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("paymentDetailss", paymentDetailsService.list()))
        .message("PaymentDetailss retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getPaymentDetails(@PathVariable Long id) {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("paymentDetails", paymentDetailsService.get(id)))
        .message("PaymentDetails retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updatePaymentDetails(@PathVariable Long id, @RequestBody @NotNull PaymentDetailsDTO paymentDetailsDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("paymentDetails", paymentDetailsService.update(id, paymentDetailsDTO)))
            .message("PaymentDetails updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deletePaymentDetails(@PathVariable Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("paymentDetails", paymentDetailsService.delete(id)))
            .message("PaymentDetails deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
    
}
