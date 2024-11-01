package com.example.cronogame.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    //modifier: Modifier,
    title: String,
    buttonIcon: ImageVector,
    onButtonClick: () -> Unit,
    backgroundColor: Color = Color(0xff73459f),
    iconColor: Color = Color.White)
    {
        TopAppBar(
            title = { Text(text = title, color = iconColor) },
            navigationIcon = {
                IconButton(onClick = onButtonClick) {
                    Icon(imageVector = buttonIcon,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(40.dp))
                }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backgroundColor
                )
            )

    }


@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    TopBar(
        title = "CronoGame",
        buttonIcon = Icons.Default.ArrowBack,
        onButtonClick = {},
        backgroundColor = Color(0xff73459f),
        iconColor = Color.White
    )
}
