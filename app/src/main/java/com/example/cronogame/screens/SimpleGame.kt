package com.example.cronogame.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cronogame.components.DraggableCard
import com.example.cronogame.components.TimelineRow
import com.example.cronogame.models.HistoricalEvent
import com.example.cronogame.models.categoryEvents
import com.example.cronogame.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun SimpleGameScreen(navController: NavController, categoryId: Int) {
    // Obtener los eventos de la categoría
    val initialEvents = remember { categoryEvents[categoryId] ?: emptyList() }

    // Estados para manejar el juego
    var attemptsLeft by remember { mutableStateOf(3) }
    var eventsList by remember { mutableStateOf(initialEvents) }
    var timeline by remember { mutableStateOf(mutableListOf<HistoricalEvent>()) }

    // Función para manejar un timeline inválido
    fun handleInvalidTimeline() {
        attemptsLeft -= 1
        if (attemptsLeft <= 0) {
            // Navegar a la pantalla de resultados
            navController.navigate(AppScreens.ResultScreen.route) {
                popUpTo(AppScreens.SimpleGameScreen.route) { inclusive = true }
            }
        }
    }

    // Función para manejar eventos soltados
    fun onEventDropped(event: HistoricalEvent) {
        timeline.add(event)
        eventsList = eventsList.drop(1)
        validateTimeline(timeline) { isValid ->
            if (!isValid) handleInvalidTimeline()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Categoría: $categoryId") }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Mostrar mensaje si no hay eventos
                if (eventsList.isEmpty()) {
                    Text("No hay más eventos para esta categoría.")
                } else {
                    // Mostrar tarjeta draggable
                    DraggableCard(
                        event = eventsList.first(),
                        onDropped = { event -> onEventDropped(event) }
                    )
                }

                // Mostrar línea de tiempo
                TimelineRow(timeline = timeline)

                // Mostrar intentos restantes
                Text(
                    text = "INTENTOS RESTANTES: $attemptsLeft",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    )
}

// Validar si la línea de tiempo está ordenada cronológicamente
fun validateTimeline(timeline: List<HistoricalEvent>, onValidationComplete: (Boolean) -> Unit) {
    val isValid = timeline.zipWithNext().all { (firstEvent, secondEvent) ->
        firstEvent.year <= secondEvent.year
    }
    onValidationComplete(isValid)
}
