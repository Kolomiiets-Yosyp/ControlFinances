package com.example.controlfinances.service;

import com.example.controlfinances.dao.TransactionDao;
import com.example.controlfinances.models.Transaction;
import com.example.controlfinances.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionService extends SessionUtil implements TransactionDao {

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        openTransactionSession();

        Session session = getSession();
        session.save(transaction);

        closeTransactionSession();

        return transaction;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Session session = openSession();
        try {
            String hql = "SELECT * FROM transactions WHERE id = :id";
            Query<Transaction> query = session.createNativeQuery(hql, Transaction.class);
            query.setParameter("id", id);

            Transaction transaction = query.uniqueResult();
            return transaction;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        Session session = openSession();
        try {
            String hql = "SELECT * FROM transactions";
            Query<Transaction> query = session.createNativeQuery(hql, Transaction.class);
            List<Transaction> transactionList = query.list();
            return transactionList;
        } finally {
            session.close();
        }
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Session session = openSession();
        try {
            session.getTransaction().begin();
            session.update(transaction);
            session.getTransaction().commit();
            return transaction;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteTransactionById(Long id) {
        Session session = openSession();
        try {
            session.getTransaction().begin();
            Transaction transaction = session.get(Transaction.class, id);
            if (transaction != null) {
                session.delete(transaction);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
