package com.example.cronogame.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.cronogame.components.Models.HistoricalEvent
import com.example.cronogame.components.Models.categoryEvents

@Composable
fun SimpleGameScreen (navController: NavController){
    var attemptsLeft by remember { mutableIntStateOf(3) }
    var eventsList by remember { mutableStateOf(categoryEvents[categoryId] ?: emptyList()) }
    var timeline by remember { mutableStateOf(mutableListOf<HistoricalEvent>()) }




}