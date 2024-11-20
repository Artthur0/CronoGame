package com.example.cronogame.components

import android.media.metrics.Event
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cronogame.R
import com.example.cronogame.models.HistoricalEvent

@Composable
fun DraggableCard(event: HistoricalEvent, onDropped: (HistoricalEvent) -> Unit) {
    val dragPosition = remember { mutableStateOf(Offset(0f, 0f)) }

    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
            .background(Color.Gray)
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    dragPosition.value = dragPosition.value.copy(
                        x = dragPosition.value.x + dragAmount.x,
                        y = dragPosition.value.y + dragAmount.y
                    )
                }
            }
            .offset { IntOffset(dragPosition.value.x.toInt(), dragPosition.value.y.toInt()) }
    ) {
        TarjetaGlobal(
            id = event.id.toString(),
            imagenRes = R.drawable.ic_launcher_foreground,
            texto = event.name,
            fecha = event.year.toString()
        )

        Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                onDropped(event)
            })
        }
    }
}

@Composable
fun TarjetaGlobal(
    id: String,
    imagenRes: Int,
    texto: String,
    fecha: String? = null
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "ID: $id",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))

            Image(
                painter = painterResource(id = imagenRes),
                contentDescription = "Imagen de la tarjeta",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = texto,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            fecha?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Fecha: $it",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTarjeta() {
    TarjetaGlobal(
        id = "1",
        imagenRes = R.drawable.ic_launcher_foreground,
        texto = "Evento histórico",
        fecha = "1800"
    )
}
