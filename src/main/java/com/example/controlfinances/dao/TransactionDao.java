package com.example.controlfinances.dao;

import com.example.controlfinances.models.Transaction;

import java.util.List;

public interface TransactionDao {
    // Збереження нової транзакції
    Transaction saveTransaction(Transaction transaction);

    // Отримання транзакції за її ідентифікатором
    Transaction getTransactionById(Long id);

    // Отримання списку всіх транзакцій для користувача за його ідентифікатором
    List<Transaction> getTransactionsByUserId(Long userId);

    List<Transaction> getAllTransactions();

    // Оновлення існуючої транзакції
    Transaction updateTransaction(Transaction transaction);

    // Видалення транзакції за її ідентифікатором
    void deleteTransactionById(Long id);
}
