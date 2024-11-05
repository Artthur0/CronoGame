package com.example.cronogame.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cronogame.components.Category
import com.example.cronogame.components.TopBar


@Composable
fun SelectCategory() {
    val categories =
        listOf("Categoría 1", "Categoría 2", "Categoría 3", "Categoría 4", "Categoría 5")
    Scaffold(
        topBar = {
            TopBar(
                title = "Selecciona una categoría",
                buttonIcon = Icons.Default.ArrowBack,
                onButtonClick = { },
                backgroundColor = Color(0xff73459f),
                iconColor = Color.White
            )
        },
        containerColor = Color(0xff73459f)
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            items(categories) { category ->
                Category(
                    text = category,
                    onClick = { /* Acción de categoría */ },
                    backgroundColor = Color(0xffFFC900),
                    textColor = Color.White

                )
                Spacer(modifier = Modifier.height(10.dp))


            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectCategory() {
    SelectCategory()

}
