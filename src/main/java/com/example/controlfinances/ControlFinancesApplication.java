package com.example.controlfinances;

import com.example.controlfinances.models.User;
import com.example.controlfinances.service.UserService;
import com.example.controlfinances.util.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlFinancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlFinancesApplication.class, args);
        UserService userService = new UserService();

        User user = new User();
        user.setId(3L);
        user.setUsername("username");
        user.setPassword("password");
        System.out.printf(user.toString());
        userService.saveUser(user);
        HibernateUtil.shutdown();
    }

}
