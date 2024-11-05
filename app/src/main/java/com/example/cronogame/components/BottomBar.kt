package com.example.cronogame.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cronogame.navigation.AppScreens
import com.example.cronogame.navigation.AppNavigation

@Composable
fun BottomBar(navController:NavController
){
    BottomAppBar (
        containerColor = Color.White,
        contentColor = Color(0xFF6A1B9A),
        tonalElevation = 4.dp
    ) {
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { /*Acción*/ }
            ) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Perfil" )
                Spacer(modifier = Modifier.height(4.dp))
                Text("Perfil", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {  }
            ){
                Icon(Icons.Default.Home, contentDescription = "Home" )
                Spacer(modifier = Modifier.height(4.dp))
                Text("Home", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {navController.navigate(AppScreens.ResultScreen.route)}
            ) {
                Icon(Icons.Default.CheckCircle, contentDescription = "Perfil" )
                Spacer(modifier = Modifier.height(4.dp))
                Text("Historial", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
