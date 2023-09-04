package com.example.mystore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mystore.ui.components.AppConfig
import com.example.mystore.ui.theme.MyStoreTheme
import com.example.mystore.viewModel.DataBaseViewModel2
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStoreTheme {
                navController = rememberNavController()
                AppConfig(navController = navController)
//                val viewModel by viewModels<DataBaseViewModel2>()
//                viewModel.deleteAllProducts()
            }
        }
    }
}









