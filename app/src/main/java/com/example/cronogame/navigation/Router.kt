package com.example.cronogame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cronogame.screens.Home
import com.example.cronogame.screens.HowToPlayScreen
import com.example.cronogame.screens.ResultScreen
import com.example.cronogame.screens.GameScreen
import com.example.cronogame.screens.SelectCategory

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route){
        composable(route= AppScreens.HomeScreen.route){
            Home(navController)
        }
        composable(route= AppScreens.HelpScreen.route){
            HowToPlayScreen(navController)
        }
        composable(route= AppScreens.ResultScreen.route){
            ResultScreen(navController, 2) //Reemplazar con logica para score
        }
        composable(route= AppScreens.GameScreen.route) {
            GameScreen(navController)
        }
        composable(route = AppScreens.SelectCategory.route){
            SelectCategory(navController)
        }

    }
}