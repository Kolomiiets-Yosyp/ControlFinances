package com.example.controlfinances;

import com.example.controlfinances.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlFinancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlFinancesApplication.class, args);
        UserService userService = new UserService();
        userService.getUserById(1L);
    }

}
