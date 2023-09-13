package com.example.controlfinances.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Повертаємо ім'я HTML файлу без розширення
    }


}