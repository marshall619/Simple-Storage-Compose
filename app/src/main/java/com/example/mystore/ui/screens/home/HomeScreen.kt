package com.example.mystore.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mystore.ui.components.HeaderTextApp

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 58.dp)) {
        HeaderTextApp()
        StoreSection(navController = navController)
    }
}