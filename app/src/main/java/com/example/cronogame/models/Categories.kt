package com.example.cronogame.models

// Representamos las categorías con su nombre
data class Category(
    val id: Int,
    val name: String,
    val events: List<HistoricalEvent>
)

val categoryEvents = mapOf(
    1 to Category(
        id = 1,
        name = "Categoría A",
        events = listOf(
            HistoricalEvent(1, "Evento A", 1800),
            HistoricalEvent(2, "Evento B", 1850),
            HistoricalEvent(3, "Evento C", 1900)
        )
    ),
    2 to Category(
        id = 2,
        name = "Categoría B",
        events = listOf(
            HistoricalEvent(1, "Evento D", 1700),
            HistoricalEvent(2, "Evento E", 1750),
            HistoricalEvent(3, "Evento F", 1800)
        )
    )
)
