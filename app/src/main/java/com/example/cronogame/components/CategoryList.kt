package com.example.cronogame.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cronogame.models.CategoriesData

@Composable
fun CategoryList(
    categories: List<CategoriesData>,
    onCategoryClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        categories.forEach { category ->
            Category(
                text = category.name,
                onClick = { onCategoryClick(category.name) },
                backgroundColor = Color(0xffFFC900),
                textColor = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryList() {
    val sampleCategories = listOf(
        CategoriesData("Categoría 1"),
        CategoriesData("Categoría 2"),
        CategoriesData("Categoría 3")
    )

    CategoryList(
        categories = sampleCategories,
        onCategoryClick = { categoryName ->
            // Aquí puedes manejar el clic en la categoría
            println("Categoría seleccionada: $categoryName")
        }
    )
}