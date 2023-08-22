package com.example.controlfinances.dao.imp;

import com.example.controlfinances.dao.UserDao;
import com.example.controlfinances.models.User;
import com.example.controlfinances.models.Role;
import com.example.controlfinances.models.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        // Збереження користувача
        entityManager.persist(user);

        // Створення запису в таблиці user_roles для надання ролі "user"
        UserRole userRole = new UserRole(user.getId(), 2L); // 2L - ID ролі "user"
        entityManager.persist(userRole);
    }


    @Override
    @Transactional
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        String sql = "SELECT * from users";
        return entityManager.createNativeQuery(sql, User.class).getResultList();
    }


    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
