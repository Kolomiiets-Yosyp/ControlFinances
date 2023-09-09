package com.example.controlfinances;


import com.example.controlfinances.dao.imp.UserDaoImpl;
import com.example.controlfinances.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlFinancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlFinancesApplication.class, args);

    }


}