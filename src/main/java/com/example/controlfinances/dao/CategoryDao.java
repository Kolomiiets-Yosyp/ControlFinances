package com.example.controlfinances.dao;

import com.example.controlfinances.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao {
    // Збереження нової категорії
    Category saveCategory(Category category);

    // Отримання категорії за її ідентифікатором
    Category getCategoryById(Long id);

    // Отримання категорії за її назвою
    Category getCategoryByName(String name);

    // Отримання списку всіх категорій
    List<Category> getAllCategories();

    // Оновлення існуючої категорії
    Category updateCategory(Category category);

    // Видалення категорії за її ідентифікатором
    void deleteCategoryById(Long id);
}

