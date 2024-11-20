package com.example.cronogame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.cronogame.components.DraggableCard
import com.example.cronogame.components.TimelineRow
import com.example.cronogame.database.AppDatabase
import com.example.cronogame.database.entities.HistoricalEvent
import com.example.cronogame.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController, categoryId: Int) {
//    val context = LocalContext.current
//    val database = remember {
//        Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "historical_events_db"
//        ).build()
//    } }



//    var attemptsLeft by remember { mutableStateOf(3) }
//    var eventsList by remember { mutableStateOf(listOf<HistoricalEvent>()) }
//    var isLoading by remember { mutableStateOf(true) }
//    var timeline by remember { mutableStateOf(mutableListOf<HistoricalEvent>()) }
//
//    // Cargar eventos desde la base de datos
//    LaunchedEffect(Unit) {
//        try {
//            eventsList = database.historicalEventDao().getEventsByCategory(categoryId, limit = 10)
//        } catch (e: Exception) {
//            //mensaje de error o algo
//            eventsList = emptyList()
//        } finally {
//            isLoading = false
//        }
//    }
//
//    fun handleInvalidTimeline() {
//        attemptsLeft -= 1
//        if (attemptsLeft <= 0) {
//            navController.navigate(AppScreens.ResultScreen.route) {
//                popUpTo(AppScreens.GameScreen.route) { inclusive = true }
//            }
//        }
//    }
//
//    fun onEventDropped(event: HistoricalEvent) {
//        timeline.add(event)
//        eventsList = eventsList.drop(1) // Eliminar el evento de la lista
//        validateTimeline(timeline) { isValid ->
//            if (!isValid) handleInvalidTimeline()
//        }
//    }
//
//    if (isLoading) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            CircularProgressIndicator()
//        }
//    } else {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically,
//                            modifier = Modifier.fillMaxWidth()
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .clip(CircleShape)
//                                    .background(Color(0xFF6A1B9A))
//                                    .size(36.dp)
//                            ) {
//                                IconButton(onClick = { /* Acción de pausa */ }) {
//                                    Icon(
//                                        imageVector = Icons.Default.Send,
//                                        contentDescription = "Pausa",
//                                        tint = Color.White
//                                    )
//                                }
//                            }
//
//                            Spacer(modifier = Modifier.width(8.dp))
//
//                            Text(
//                                text = "Nombre de Categoría",
//                                color = MaterialTheme.colorScheme.onBackground
//                            )
//                        }
//                    }
//                )
//            },
//            content = { innerPadding ->
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(innerPadding)
//                        .padding(16.dp),
//                    verticalArrangement = Arrangement.SpaceBetween,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    if (eventsList.isEmpty()) {
//                        Text("No hay eventos disponibles para esta categoría.")
//                    } else {
//                        DraggableCard(
//                            event = eventsList.first(),
//                            onDropped = { event -> onEventDropped(event) }
//                        )
//                    }
//
//                    TimelineRow(timeline = timeline)
//
//                    Text(
//                        text = "INTENTOS RESTANTES: $attemptsLeft",
//                        style = MaterialTheme.typography.titleLarge
//                    )
//                }
//            }
//        )
//    }
//}
//
//fun validateTimeline(timeline: MutableList<HistoricalEvent>, onValidationComplete: (Boolean) -> Unit) {
//    val isValid = timeline.zipWithNext().all { (firstEvent, secondEvent) ->
//        firstEvent.year <= secondEvent.year
//    }
//    onValidationComplete(isValid)
}
