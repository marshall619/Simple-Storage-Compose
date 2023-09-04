package com.example.mystore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mystore.ui.screens.home.HomeScreen
import com.example.mystore.ui.screens.Login.LoginScreen
import com.example.mystore.ui.screens.Splash.SplashScreen
import com.example.mystore.ui.screens.add.AddScreen
import com.example.mystore.ui.screens.claim.ClaimScreen
import com.example.mystore.ui.screens.home.DescriptionScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.Claim.route) {
            ClaimScreen(navController = navController)
        }

        composable(Screen.Add.route) {
            AddScreen(navController = navController)
        }

        composable(route = Screen.Des.route + "?description={description}",
            arguments = listOf(
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = " "
                    nullable = true
                }
            )
        ) {
            it.arguments!!.getString("description")?.let { description ->
                DescriptionScreen(
                    navController = navController,
                    description = description
                )
            }
        }
    }
}

