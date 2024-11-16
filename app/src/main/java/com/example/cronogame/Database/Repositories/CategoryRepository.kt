package com.example.cronogame.Database.Repositories

import com.example.cronogame.Database.dao.CategoryDao
import com.example.cronogame.Database.entities.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    suspend fun getAllCategories(): List<Category> {
        return categoryDao.getAllCategories()
    }
}
