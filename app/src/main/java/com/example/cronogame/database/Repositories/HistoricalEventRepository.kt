package com.example.cronogame.database.Repositories

import com.example.cronogame.database.dao.HistoricalEventDao
import com.example.cronogame.database.entities.HistoricalEvent

class HistoricalEventRepository(private val eventDao: HistoricalEventDao) {
    suspend fun insertEvent(event: HistoricalEvent) {
        eventDao.insertEvent(event)
    }

    suspend fun getEventsByCategory(categoryId: Int, limit: Int = 10): List<HistoricalEvent> {
        return eventDao.getEventsByCategory(categoryId, limit)
    }

}
