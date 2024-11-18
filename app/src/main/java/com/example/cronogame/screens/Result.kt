package com.example.cronogame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cronogame.R
import com.example.cronogame.navigation.AppScreens
import com.example.cronogame.components.Button
import com.example.cronogame.components.TopBar

@Composable
fun ResultScreen(navController: NavController, score: Int) {
    val ganar=true;
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
                    text = "¡Juego terminado!",
                    fontSize = 32.sp,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Text(
                    text = "Puntuación: $score",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))
                if(ganar==true){
                    Image(
                        painter = painterResource(id = R.drawable.ganar),
                        contentDescription = "Logo App",
                        modifier = Modifier.size(200.dp)
                    )
                }
                else{
                    Image(
                        painter = painterResource(id = R.drawable.perder),
                        contentDescription = "Logo App",
                        modifier = Modifier.size(300.dp)
                    )
                }


                Spacer(modifier = Modifier.height(20.dp))


                Button(text = "VOLVER AL MENÚ",
                    onClick = {navController.navigate(AppScreens.HomeScreen.route)},
                    backgroundColor = Color(0xff43bccd),
                    textColor = Color.White)

            }
        }
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewResultScreen() {
    // Simulamos el `NavController`
    val navController = rememberNavController()

    // Llamamos a `ResultScreen` con datos de ejemplo
    ResultScreen(
        navController = navController,
        score = 100 // Valor de ejemplo para la puntuación
    )
}
