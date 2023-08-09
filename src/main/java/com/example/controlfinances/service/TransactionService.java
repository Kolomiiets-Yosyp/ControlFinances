package com.example.controlfinances.service;

import com.example.controlfinances.dao.TransactionDao;
import com.example.controlfinances.models.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionService extends SessionUtil implements TransactionDao {
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        Session session = openSession();
        try {
            session.getTransaction().begin();
            session.save(transaction);
            session.getTransaction().commit();
            return transaction;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    // Попередні методи (saveTransaction, updateTransaction, deleteTransactionById) залишаються незмінними

    @Override
    public Transaction getTransactionById(Long id) {
        Session session = openSession();
        try {
            String hql = "FROM transactions WHERE id = :id";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("id", id);

            Transaction transaction = query.uniqueResult();
            return transaction;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Long user_id) {
        Session session = openSession();
        try {
            String hql = "FROM transactions WHERE id= :user_id";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("userId", user_id);

            List<Transaction> transactions = query.list();
            return transactions;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        Session session = openSession();
        try {
            String hql = "FROM transactions";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
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
