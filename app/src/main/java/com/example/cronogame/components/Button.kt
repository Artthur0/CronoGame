package com.example.cronogame.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color.Gray,
    textColor: Color = Color.White
){
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center)
    {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.8f)
            .padding(8.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        )
    ){
        Text(text = text, color = textColor)
    }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    Button (
        text = "PLAY",
        onClick = {},
        backgroundColor = Color(0xffFFC900),
        textColor = Color.White
    )

}