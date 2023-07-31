package com.example.controlfinances.dao;

import com.example.controlfinances.models.Transaction;

import java.util.List;

public interface TransactionDao {
    // Збереження нової транзакції
    void saveTransaction(Transaction transaction);

    // Отримання транзакції за її ідентифікатором
    Transaction getTransactionById(Long id);

    // Отримання списку всіх транзакцій для користувача за його ідентифікатором
    List<Transaction> getTransactionsByUserId(Long userId);

    // Отримання списку всіх транзакцій для категорії за її ідентифікатором
    List<Transaction> getTransactionsByCategoryId(Long categoryId);

    // Оновлення існуючої транзакції
    void updateTransaction(Transaction transaction);

    // Видалення транзакції за її ідентифікатором
    void deleteTransactionById(Long id);
}
