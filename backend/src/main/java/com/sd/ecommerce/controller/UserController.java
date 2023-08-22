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

import com.sd.ecommerce.model.User;
import com.sd.ecommerce.service.implementation.UserServiceImpl;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<Response> createUser(@RequestBody @NotNull User user) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("user", userService.save(user)))
            .message("User created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listUsers() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("users", userService.list()))
        .message("Users retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUser(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("user", userService.get(id)))
            .message("User retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@NotNull Long id, @RequestBody @NotNull User user) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("user", userService.update(id, user)))
            .message("User updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUser(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("user", userService.delete(id)))
            .message("User deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
    
}
