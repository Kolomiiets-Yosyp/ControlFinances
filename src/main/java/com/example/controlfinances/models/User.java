package com.example.controlfinances.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    private String password;



    // Додайте поля та взаємозв'язки з іншими сутностями
    // ...
}

