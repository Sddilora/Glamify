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

import com.sd.ecommerce.dto.UserDTO;
import com.sd.ecommerce.dto.UserRegistrationDTO;
import com.sd.ecommerce.service.UserService;
import com.sd.ecommerce.util.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserRegistrationDTO UserRegistrationDTO) {

        UserDTO user = userService.save(UserRegistrationDTO); // Convert DTO to entity

        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("user", user))
            .message("User registered")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    // @PostMapping("/login")
    // public ResponseEntity<Response> authenticateUser(@RequestBody @NotNull UserAuthDTO UserAuthDTO) {
    //     boolean is_user = userService.authenticateUser(UserMapper.convertToEntity(UserAuthDTO));
    //     return ResponseEntity.ok(
    //         Response.builder()
    //         .timeStamp(now())
    //         .data(Map.of("user", UserAuthDTO, "is_user", is_user))
    //         .message(is_user ? "User authenticated" : "User not authenticated")
    //         .status(OK)
    //         .statusCode(OK.value())
    //         .build()
    //     );
    // }

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

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") Long id) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable("id") Long id, @RequestBody @NotNull UserRegistrationDTO UserRegistrationDTO) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("user", userService.update(id, UserRegistrationDTO)))
            .message("User updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Long id) {
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
