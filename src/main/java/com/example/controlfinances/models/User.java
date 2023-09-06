package com.example.controlfinances.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotEmpty(message = "The name must not be empty")
    private String username;
    @NotNull(message = "Write the password")
    @Column(name = "password")
    @Size(min = 6, message = "The password must contain at least 5 characters")
    private String password;

    @Column(name = "balance")
    private long balance;

    public User(String username, String password, long balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    // Додайте поля та взаємозв'язки з іншими сутностями
    // ...
}

