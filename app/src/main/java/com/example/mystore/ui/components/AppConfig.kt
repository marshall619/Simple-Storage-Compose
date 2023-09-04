package com.example.mystore.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mystore.navigation.BottomNavigationBar
import com.example.mystore.navigation.Screen
import com.example.mystore.navigation.SetupNavGraph
import com.example.mystore.ui.theme.loginBoxTopColor
import com.example.mystore.util.Constants.PHOTO_INDEX
import com.example.mystore.viewModel.DataStoreViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppConfig(navController: NavHostController){
    ChangeTopBarColor(navController)
    SetPhotoIndex()
    SetDirection(navController)
}

@Composable
private fun ChangeTopBarColor(navController: NavHostController){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.White
                )
            }
        }
        Screen.Login.route ->{
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = loginBoxTopColor
                )
            }
        }
        Screen.Splash.route ->{
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.White
                )
            }
        }
        else -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = loginBoxTopColor
                )
            }
        }
    }

}

@Composable
fun SetPhotoIndex(viewModel: DataStoreViewModel = hiltViewModel()){
     PHOTO_INDEX = viewModel.getPhotoIndex()!!
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun SetDirection(navController: NavHostController){

    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        Scaffold (bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onItemClick = {
                    if(it.route == Screen.Home.route){
                        navController.navigate(it.route)
                    }else{
                        navController.navigate(it.route){
                            popUpTo(it.route){
                                inclusive = true
                            }
                        }
                    }

                })
        }){
            //show screens with navController & the screen is Splash for start
            SetupNavGraph(navController = navController)
        }
    }
}