package com.example.cronogame.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cronogame.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HowToPlayScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Botón con icono para regresar
                        IconButton(onClick = { navController.navigate(AppScreens.HomeScreen.route) }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Volver a Inicio"
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))

                        // Título de la pantalla
                        Text(text = "How to Play")
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                // Texto de ejemplo
                Text(
                    text = "Este es un ejemplo de texto que describe cómo jugar.",
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    )
}
