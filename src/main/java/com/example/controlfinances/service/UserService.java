package com.example.controlfinances.service;
import com.example.controlfinances.dao.UserDao;
import com.example.controlfinances.models.User;
import com.example.controlfinances.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.List;

public class UserService extends SessionUtil implements UserDao {
    @Override
    public User saveUser(User user) {
        openTransactionSession();

        Session session = getSession();
        session.save(user);

        closeTransactionSession();

        return null;
    }

    @Override
    public User getUserById(Long id) {
        openTransactionSession();
        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";

closeTransactionSession();
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}



