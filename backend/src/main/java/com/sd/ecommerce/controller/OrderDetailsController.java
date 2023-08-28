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

import com.sd.ecommerce.dto.OrderDetailsDTO;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;
import com.sd.ecommerce.service.OrderDetailsService;

@RestController
@RequestMapping("/orderdetails")
@RequiredArgsConstructor
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @PostMapping
    public ResponseEntity<Response> createOrderDetails(@RequestBody @NotNull OrderDetailsDTO orderDetailsDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("orderDetails", orderDetailsService.save(orderDetailsDTO)))
            .message("OrderDetails created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping
    public ResponseEntity<Response> listOrderDetailss() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("orderDetailss", orderDetailsService.list()))
        .message("OrderDetailss retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getOrderDetails(@PathVariable Long id) {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("orderDetails", orderDetailsService.get(id)))
        .message("OrderDetails retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateOrderDetails(@PathVariable Long id, @RequestBody @NotNull OrderDetailsDTO orderDetailsDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("orderDetails", orderDetailsService.update(id, orderDetailsDTO)))
            .message("OrderDetails updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteOrderDetails(@PathVariable Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("orderDetails", orderDetailsService.delete(id)))
            .message("OrderDetails deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
    
}
