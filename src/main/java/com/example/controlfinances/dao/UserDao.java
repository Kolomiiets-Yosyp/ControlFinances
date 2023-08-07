package com.example.controlfinances.dao;

import com.example.controlfinances.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    // Збереження нового користувача
    User saveUser(User user);

    // Отримання користувача за його ідентифікатором
    User getUserById(Long id);

    // Отримання користувача за його іменем
    User getUserByUsername(String username);

    // Отримання списку всіх користувачів
    List<User> getAllUsers();

    // Оновлення існуючого користувача
    User updateUser(User user);

    // Видалення користувача за його ідентифікатором
    void deleteUserById(Long id);
}
