package com.eventify.eventify_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventify.eventify_service.dto.UserDTORequest;
import com.eventify.eventify_service.dto.UserDTOResponse;
import com.eventify.eventify_service.model.User;
import com.eventify.eventify_service.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 🔥 CREATE (should use DTO ideally — we’ll improve next)
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    // 🔥 GET ALL
    @GetMapping
    public List<UserDTOResponse> getAll() {
        return userService.getAllUsers();
    }

    // 🔥 GET BY ID
    @GetMapping("/{id}")
    public UserDTOResponse getById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // 🔥 UPDATE
    @PutMapping("/{id}")
    public User update(@PathVariable String id,
                       @Valid @RequestBody UserDTORequest dto) {

        return userService.updateUser(id, dto);
    }

    // 🔥 DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}