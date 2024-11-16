package com.example.cronogame.Database.dao

import HistoricalEvent
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoricalEventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: HistoricalEvent)

    @Query("SELECT * FROM historical_events WHERE categoryId = :categoryId ORDER BY year ASC")
    suspend fun getEventsByCategory(categoryId: Int): List<HistoricalEvent>
}
