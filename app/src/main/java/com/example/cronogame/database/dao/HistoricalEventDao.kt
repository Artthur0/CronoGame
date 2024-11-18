package com.example.cronogame.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cronogame.database.entities.HistoricalEvent

@Dao
interface HistoricalEventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: HistoricalEvent)

    @Query("SELECT * FROM historical_events WHERE categoryId = :categoryId ORDER BY RANDOM() LIMIT :limit")
    suspend fun getEventsByCategory(categoryId: Int, limit: Int): List<HistoricalEvent>
}
