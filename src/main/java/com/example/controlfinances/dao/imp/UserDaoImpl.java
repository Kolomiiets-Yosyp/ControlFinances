package com.example.controlfinances.dao.imp;

import com.example.controlfinances.dao.UserDao;
import com.example.controlfinances.models.User;
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
    public User saveUser(User user) {
       
        return null;
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public User getUserByUsername(String username) {
        return null;
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
