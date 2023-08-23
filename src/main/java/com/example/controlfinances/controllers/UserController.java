package com.example.controlfinances.controllers;

import com.example.controlfinances.dao.imp.UserDaoImpl;
import com.example.controlfinances.dao.imp.UserRoleDaoImpl;
import com.example.controlfinances.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Controller
public class UserController {

    private UserDaoImpl userDaoImpl;
    private UserRoleDaoImpl userRoleDaoImpl;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String homePage() {
        return "home.html"; // Повертаємо ім'я HTML файлу без розширення
    }


    public UserController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userDaoImpl.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public String createUser(@RequestParam String name, @RequestParam String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(name, encodedPassword);
        userDaoImpl.saveUser(user);
        System.out.println(user);
        return "redirect:/login"; // Перенаправлення на сторінку входу
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Вертаємо ім'я HTML файлу без розширення
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userDaoImpl.getUserByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Користувач аутентифікований, ви можете здійснити додаткові дії тут
            return "redirect:/home"; // Перенаправлення на домашню сторінку
        } else {
            model.addAttribute("error", "Невірний логін або пароль");
            return "login"; // Вертаємо сторінку логінації з помилкою
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteTransaction(@PathVariable Long id) {
        userDaoImpl.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDaoImpl.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Додайте інші методи для оновлення, видалення тощо
}
