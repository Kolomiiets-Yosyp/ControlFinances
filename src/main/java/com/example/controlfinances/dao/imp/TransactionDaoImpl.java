package com.example.controlfinances.dao.imp;

import com.example.controlfinances.dao.TransactionDao;
import com.example.controlfinances.models.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        entityManager.persist(transaction);
        return transaction;
    }

    @Override
    @Transactional
    public Transaction getTransactionById(Long id) {
        return entityManager.find(Transaction.class, id);
    }

    @Override
    @Transactional
    public List<Transaction> getTransactionsByUserId(Long userId) {
        String sql = "SELECT * FROM transactions WHERE user_id = :userId";
        return entityManager.createNativeQuery(sql, Transaction.class)
                .setParameter("userId", userId)
                .getResultList();
    }


    @Override
    @Transactional
    public List<Transaction> getAllTransactions() {
        String sql = "SELECT * from transactions";
        return entityManager.createNativeQuery(sql, Transaction.class).getResultList();
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return entityManager.merge(transaction);
    }

    @Override
    public void deleteTransactionById(Long id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        if (transaction != null) {
            entityManager.remove(transaction);
        }
    }
}
