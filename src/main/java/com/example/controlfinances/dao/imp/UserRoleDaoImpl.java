package com.example.controlfinances.dao.imp;

import com.example.controlfinances.dao.UserRoleDao;
import com.example.controlfinances.models.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRoleDaoImpl implements UserRoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUserRole(UserRole userRole) {
        entityManager.persist(userRole);
    }
}
