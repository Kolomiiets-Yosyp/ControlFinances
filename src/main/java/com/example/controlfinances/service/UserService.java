package com.example.controlfinances.service;
import com.example.controlfinances.dao.UserDao;
import com.example.controlfinances.models.User;
import com.example.controlfinances.util.HibernateUtil;
import com.example.controlfinances.util.SessionUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class UserService extends SessionUtil implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        openTransactionSession();

        Session session = getSession();
        session.save(user);

        closeTransactionSession();

        return user;
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
        Session session = null;
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
    @Transactional
    public List<User> getAllUsers() {
        String hql = "SELECT u FROM users u";
        return entityManager.createQuery(hql, User.class).getResultList();
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



