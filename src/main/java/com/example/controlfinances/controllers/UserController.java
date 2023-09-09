package com.example.controlfinances.controllers;

import com.example.controlfinances.dao.imp.UserDaoImpl;
import com.example.controlfinances.dao.imp.UserRoleDaoImpl;
import com.example.controlfinances.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedString;
import java.util.List;

@Controller
public class UserController {

    private UserDaoImpl userDaoImpl;
    private UserRoleDaoImpl userRoleDaoImpl;
    Model model;

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

    @GetMapping("/home")
    public String homePage() {
        return "home"; // Повертаємо ім'я HTML файлу без розширення
    }

    @GetMapping("/create")
    public String create() {
        return "register"; // Повертаємо ім'я HTML файлу без розширення
    }

    @PostMapping("/create")
    public String createUser(@RequestParam String name,
                             @RequestParam String password,
                             @RequestParam(required = false, defaultValue = "0") long balance) {

        User user = new User(name, password, balance);
        userDaoImpl.saveUser(user);
        System.out.println(user);
        return "redirect:/login";
        // Перенаправлення на сторінку входу
    }

//    @GetMapping("/login")
//    public String loginPage() {
//        return "login"; // Вертаємо ім'я HTML файлу без розширення
//    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String userName,
            @RequestParam String userPassword,
            Model model) {

        User existingUser = userDaoImpl.getUserByUsername(userName);
        if (existingUser != null && existingUser.getPassword().equals(userPassword)) {
            // Авторизація успішна
            // Додаємо баланс користувача до моделі
            model.addAttribute("userBalance", existingUser.getBalance());
            // Перенаправляємо на сторінку "home"
            return "redirect:/home"; // Припустимо, що "home" - це URL для сторінки "home"
        } else {
            // Авторизація не вдалася, показуємо помилкове повідомлення
            String errorMessage = "Невірне ім'я користувача або пароль. Спробуйте ще раз.";
            // Додаємо помилкове повідомлення до моделі
            model.addAttribute("errorMessage", errorMessage);
            System.out.printf(errorMessage);
            // Повертаємо сторінку з формою логіну і помилковим повідомленням
            return "login"; // Припустимо, що "login" - це URL для сторінки логіну
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
