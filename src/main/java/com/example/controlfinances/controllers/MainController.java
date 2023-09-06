package com.example.controlfinances.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @GetMapping("/home")
    public String homePage() {
        return "home"; // Повертаємо ім'я HTML файлу без розширення
    }


}
