package com.example.cronogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cronogame.database.AppDatabase
import com.example.cronogame.database.HistoricalDataViewModel
import com.example.cronogame.database.Repositories.CategoryRepository
import com.example.cronogame.database.Repositories.HistoricalEventRepository
import com.example.cronogame.database.insertInitialData
import com.example.cronogame.navigation.AppNavigation
import com.example.cronogame.ui.theme.CronoGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getInstance(applicationContext)
        val categoryRepository = CategoryRepository(database.categoryDao())
        val eventRepository = HistoricalEventRepository(database.historicalEventDao())
        val viewModel = HistoricalDataViewModel(categoryRepository, eventRepository)
        insertInitialData(viewModel)

        setContent {
            CronoGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}