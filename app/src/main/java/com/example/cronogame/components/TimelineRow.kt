package com.example.cronogame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cronogame.database.entities.HistoricalEvent

@Composable
fun TimelineRow(timeline: List<com.example.cronogame.models.HistoricalEvent>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(timeline) { event ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .border(2.dp, Color(0xff73459f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = event.name,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color(0xff73459f))
                        .padding(4.dp)
                )
            }
        }
    }
}
