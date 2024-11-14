package com.example.cronogame.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cronogame.R

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
        id = "tarjeta_001",
        imagenRes = R.drawable.ic_launcher_foreground,
        texto = "Texto de ejemplo",
        fecha = "12/11/2024"
    )
}
