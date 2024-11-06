package com.example.cronogame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cronogame.R
import com.example.cronogame.components.BottomBar
import com.example.cronogame.components.Button
import com.example.cronogame.components.TopBar
import com.example.cronogame.navigation.AppScreens

@Composable
fun Home(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                title = "",
                buttonIcon = Icons.Default.Info,
                onButtonClick = {navController.navigate(AppScreens.HelpScreen.route)},
                backgroundColor = Color.White,
                iconColor = Color(0xff73459f)
            )
        },
        bottomBar = {
            BottomBar(navController = navController) }
            ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo App",
                    modifier = Modifier.size(400.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(text = "PLAY",
                    onClick = {navController.navigate(AppScreens.SelectCategory.route)},
                    backgroundColor = Color(0xffFFC900),
                    textColor = Color.White)

                Spacer(modifier = Modifier.height(10.dp))


            }
        }
}
