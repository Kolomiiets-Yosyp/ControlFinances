package com.example.controlfinances.dao.imp;

import com.example.controlfinances.dao.CategoryDao;
import com.example.controlfinances.models.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Category saveCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Override
    @Transactional
    public Category getCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @Transactional
    public Category getCategoryByName(String name) {
        return entityManager.find(Category.class, name);
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        String sql = "select * from Category";
        return entityManager.createNativeQuery(sql).getResultList();
    }

    @Override
    public Category updateCategory(Category category) {
        return entityManager.merge(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null)
            entityManager.remove(category);
    }
}
