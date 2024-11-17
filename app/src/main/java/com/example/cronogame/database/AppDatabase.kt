package com.example.cronogame.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cronogame.database.dao.CategoryDao
import com.example.cronogame.database.dao.HistoricalEventDao
import com.example.cronogame.database.entities.Category
import com.example.cronogame.database.entities.HistoricalEvent


@Database(entities = [Category::class, HistoricalEvent::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun historicalEventDao(): HistoricalEventDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
