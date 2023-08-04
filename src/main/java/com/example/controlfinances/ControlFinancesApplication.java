package com.example.controlfinances;

import com.example.controlfinances.models.User;
import com.example.controlfinances.service.TransactionService;
import com.example.controlfinances.service.UserService;
import com.example.controlfinances.util.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlFinancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlFinancesApplication.class, args);
        TransactionService transactionService = new TransactionService();
        System.out.printf(transactionService.getTransactionById(1l).toString());
        HibernateUtil.shutdown();
    }

}
