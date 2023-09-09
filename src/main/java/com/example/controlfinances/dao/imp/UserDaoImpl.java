package com.example.controlfinances.dao.imp;

import com.example.controlfinances.dao.UserDao;
import com.example.controlfinances.models.User;
import com.example.controlfinances.models.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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

    public User getUsernameAndPassword(User user) {

        return null;
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = :username";
        Query query = entityManager.createNativeQuery(sql, User.class);
        query.setParameter("username", username);

        List<User> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }


    @Override
    @Transactional
    public User getUserPassword(String password) {
        String sql = "SELECT * FROM users WHERE password = :password";
        Query query = entityManager.createNativeQuery(sql, User.class);
        query.setParameter("password", password);

        List<User> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Long getUserBalance(Long id) {
        String sql = "SELECT balance FROM users WHERE id = :id";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);

        try {
            // Виконуємо запит та отримуємо результат
            Object getBalance = query.getSingleResult();

            if (getBalance != null) {
                // Перевірте, чи результат не є null перед конвертацією до Long
                return ((Number) getBalance).longValue();
            } else {
                // Обробка випадку, коли результат запиту є null
                return null;
            }
        } catch (Exception e) {
            // Обробка випадку, коли немає результату для даного ідентифікатора
            return null;
        }
    }


    @Override
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
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
