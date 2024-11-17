package com.example.cronogame.database.Repositories

import com.example.cronogame.database.dao.CategoryDao
import com.example.cronogame.database.entities.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    suspend fun getAllCategories(): List<Category> {
        return categoryDao.getAllCategories()
    }
}
