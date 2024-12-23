package com.example.cronogame.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.example.cronogame.components.Category
import com.example.cronogame.components.TopBar
import com.example.cronogame.database.AppDatabase
import com.example.cronogame.database.HistoricalDataViewModel
import com.example.cronogame.database.entities.Category
import com.example.cronogame.database.insertInitialData
import com.example.cronogame.navigation.AppScreens


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SelectCategory(navController: NavController) {
    val context = LocalContext.current
    val database = remember {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "historical_events_db"
        ).build()
    }

    var isLoading by remember { mutableStateOf(true) }
    var categories by remember { mutableStateOf(listOf<Category>()) }

    // Color de fondo (mismo color que el TopBar)
    val backgroundColor = Color(0xff73459f)

    // Cargar categorías desde la base de datos
    LaunchedEffect(Unit) {
        try {
            categories = database.categoryDao().getAllCategories()
        } catch (e: Exception) {
            categories = emptyList()
        } finally {
            isLoading = false
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.White)
        }
    } else {
        Scaffold(
            topBar = {
                TopBar(
                    title = "Selecciona una categoría",
                    buttonIcon = Icons.Default.ArrowBack,
                    onButtonClick = { navController.navigate(AppScreens.HomeScreen.route) },
                    backgroundColor = backgroundColor,
                    iconColor = Color.White
                )
            },
            containerColor = backgroundColor, // Fondo del Scaffold
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp)
                        .background(backgroundColor), // Fondo de la columna
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (categories.isEmpty()) {
                        Text(
                            text = "No hay categorías disponibles.",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White // Texto en blanco para mayor contraste
                        )
                    } else {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(categories) { category ->
                                Button(
                                    onClick = {
                                        navController.navigate("game_screen/${category.id}")
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp),
                                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                        contentColor = backgroundColor
                                    )
                                ) {
                                    Text(
                                        text = category.name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = backgroundColor // Texto con color del fondo
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewSelectCategory() {
    SelectCategory()

}
*/