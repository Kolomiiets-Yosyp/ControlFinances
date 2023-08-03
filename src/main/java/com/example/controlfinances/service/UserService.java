package com.example.controlfinances.service;
import com.example.controlfinances.dao.UserDao;
import com.example.controlfinances.models.User;
import com.example.controlfinances.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.controlfinances.models.User;
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
        Session session = openSession();
        try {
            String sql = "SELECT * FROM users WHERE id = :id";
            Query<User> query = session.createNativeQuery(sql, User.class);
            query.setParameter("id", id);

            User user = query.uniqueResult();
            return user;
        } finally {
            session.close();
        }
    }


    @Override
    public User getUserByUsername(String username) {
        Session session = openSession();
        try {
            String hql = "SELECT * FROM users WHERE username = :username";
            Query<User> query = session.createNativeQuery(hql, User.class);
            query.setParameter("username", username);

            User user = query.uniqueResult();
            return user;
        } finally {
            session.close();
        }
    }


    @Override
    public List<User> getAllUsers() {
        Session session = openSession();
        try {
            String hql = "SELECT * FROM users";
            Query<User> query = session.createNativeQuery(hql, User.class);
            List<User> userList = query.list();
            return userList;
        } finally {
            session.close();
        }
    }

    @Override
    public User updateUser(User user) {
        Session session = openSession();
        try {
            session.getTransaction().begin();
            session.update(user);
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = openSession();
        try {
            session.getTransaction().begin();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}



