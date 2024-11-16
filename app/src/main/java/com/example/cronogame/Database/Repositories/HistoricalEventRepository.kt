package com.example.cronogame.Database.Repositories

import HistoricalEvent
import com.example.cronogame.Database.dao.HistoricalEventDao

class HistoricalEventRepository(private val eventDao: HistoricalEventDao) {
    suspend fun insertEvent(event: HistoricalEvent) {
        eventDao.insertEvent(event)
    }

    suspend fun getEventsByCategory(categoryId: Int): List<HistoricalEvent> {
        return eventDao.getEventsByCategory(categoryId)
    }
}
