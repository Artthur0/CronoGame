package com.example.cronogame.models

data class HistoricalEvent(
    val id: Int,
    val name: String,
    val year: Int,
    val imageRes: Int? = null
)