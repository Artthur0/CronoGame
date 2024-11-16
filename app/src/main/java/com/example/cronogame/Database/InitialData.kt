package com.example.cronogame.Database

import HistoricalEvent
import com.example.cronogame.Database.entities.Category

fun insertInitialData(viewModel: HistoricalDataViewModel) {
    viewModel.insertCategory(Category(name = "Historia general"))

    viewModel.insertEvent(
        HistoricalEvent(
            categoryId = 1,
            eventName = "Descubrimiento de América",
            year = 1492
        )
    )
    viewModel.insertEvent(
        HistoricalEvent(
            categoryId = 1,
            eventName = "Revolución Francesa",
            year = 1789
        )
    )
    viewModel.insertEvent(
        HistoricalEvent(
            categoryId = 1,
            eventName = "Primera Guerra Mundial",
            year = 1914
        )
    )
}
