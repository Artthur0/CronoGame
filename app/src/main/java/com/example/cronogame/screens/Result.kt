package com.example.cronogame.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cronogame.navigation.AppScreens
import com.example.cronogame.components.Button

@Composable
fun ResultScreen(navController: NavController, score: Int) {
    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¡Juego Terminado!",
                    fontSize = 32.sp,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Text(
                    text = "Puntuación: $score",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Button(text = "REINICIAR",
                    onClick = {/*logica para reiniciar*/},
                    backgroundColor = Color(0xffFFC900),
                    textColor = Color.White)

                Button(text = "VOLVER AL MENÚ",
                    onClick = {navController.navigate(AppScreens.HomeScreen.route)},
                    backgroundColor = Color(0xffFFC900),
                    textColor = Color.White)

            }
        }
    )
}
