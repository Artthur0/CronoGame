package com.example.cronogame.Database

import HistoricalEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cronogame.Database.Repositories.CategoryRepository
import com.example.cronogame.Database.Repositories.HistoricalEventRepository
import com.example.cronogame.Database.entities.Category
import kotlinx.coroutines.launch

class HistoricalDataViewModel(
    private val categoryRepository: CategoryRepository,
    private val eventRepository: HistoricalEventRepository
) : ViewModel() {

    fun insertCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.insertCategory(category)
        }
    }

    fun insertEvent(event: HistoricalEvent) {
        viewModelScope.launch {
            eventRepository.insertEvent(event)
        }
    }

    fun getAllCategories(onResult: (List<Category>) -> Unit) {
        viewModelScope.launch {
            val categories = categoryRepository.getAllCategories()
            onResult(categories)
        }
    }

    fun getEventsByCategory(categoryId: Int, onResult: (List<HistoricalEvent>) -> Unit) {
        viewModelScope.launch {
            val events = eventRepository.getEventsByCategory(categoryId)
            onResult(events)
        }
    }
}
