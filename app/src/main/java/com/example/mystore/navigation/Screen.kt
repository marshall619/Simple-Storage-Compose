package com.example.mystore.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("Splash_Screen")
    object Home : Screen("Home_Screen")
    object Login : Screen("Login_Screen")
    object Claim : Screen("Claim_Screen")
    object Add : Screen("Add_Screen")
    object Des : Screen("Des_Screen")

}