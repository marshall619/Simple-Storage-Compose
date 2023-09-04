package com.example.mystore.ui.screens.Splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mystore.R
import com.example.mystore.navigation.Screen
import com.example.mystore.ui.components.OurLoading
import com.example.mystore.viewModel.DataStoreViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController , viewModel: DataStoreViewModel = hiltViewModel()) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_ll3qhmtj))
    Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.BottomCenter) {
        OurLoading(height = 60.dp, isDark = true)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.size(400.dp)
            )
            Spacer(modifier = Modifier.height(100.dp))
            LaunchedEffect(true){
                delay(3000)
                navController.navigate(Screen.Login.route){
                    popUpTo(Screen.Splash.route){
                        inclusive = true
                    }
                }
            }
        }
    }
}