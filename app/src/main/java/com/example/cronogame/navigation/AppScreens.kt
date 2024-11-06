package com.example.cronogame.navigation

sealed class AppScreens (
    val route: String
){
    object GameScreen: AppScreens("Game")
    object HomeScreen: AppScreens("Home")
    object HelpScreen: AppScreens("HowToPlay.kt")
    object ResultScreen: AppScreens("Result")
    object SelectCategory: AppScreens("SelectCategory")


}