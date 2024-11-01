package com.example.cronogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cronogame.screens.Home
import com.example.cronogame.ui.theme.CronoGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CronoGameTheme {
                // Llamada a HomeScreen dentro de Surface
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home(
                        title = "",
                        onTopBarButtonClick = { },
                        onBottomBarItemClick = { },
                        onCategoryButtonClick = { }
                    )
                }
            }
        }
    }
}