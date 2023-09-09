package com.example.controlfinances.dao;

import com.example.controlfinances.models.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
    // Збереження нового користувача
    void saveUser(User user);

    // Отримання користувача за його ідентифікатором
    User getUserById(Long id);

    // Отримання користувача за його іменем
    User getUserByUsername(String username);

    // Отримання користувача за його паролем
    User getUserPassword(String password);

    Long getUserBalance(Long id);

    // Отримання списку всіх користувачів
    List<User> getAllUsers();

    // Оновлення існуючого користувача
    User updateUser(User user);

    // Видалення користувача за його ідентифікатором
    void deleteUserById(Long id);
}
