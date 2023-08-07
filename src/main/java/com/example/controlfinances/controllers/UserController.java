package com.example.controlfinances.controllers;

import com.example.controlfinances.models.User;
import com.example.controlfinances.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/id")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

            return new ResponseEntity<>(users, HttpStatus.OK);

    }

    // Інші методи обробки запитів для User, наприклад, оновлення користувача, отримання всіх користувачів тощо.
}
