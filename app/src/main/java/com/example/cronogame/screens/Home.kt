package com.example.cronogame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cronogame.components.BottomBar
import com.example.cronogame.components.TopBar

@Composable
fun Home(
    title: String,
    onTopBarButtonClick: () -> Unit,
    onBottomBarItemClick: () -> Unit,
    onCategoryButtonClick: () -> Unit
) {
    Scaffold (
        topBar = {
            TopBar(
                title = title,
                buttonIcon = Icons.Default.Info,
                onButtonClick = {}
            )
        },
        bottomBar = {
            BottomBar()
        },
        content = {innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.),
                    contentDescription = "Logo App" ),

            }

        }
    ) {

    }

}