package com.example.mystore.ui.screens.home

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.h5
import com.example.mystore.ui.theme.loginBoxTopColor
import com.example.mystore.ui.theme.unSelectedBottomBar
import com.example.mystore.util.DigitHelper.digitByLocate
import com.example.mystore.viewModel.DataBaseViewModel2
import com.example.mystore.viewModel.DataStoreViewModel
import java.io.File

@Composable
fun StoreSection(
    navController: NavController,
    viewModel: DataBaseViewModel2 = hiltViewModel(),
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
) {
    val allItems by viewModel.allProducts.collectAsState(emptyList())
    val context = LocalContext.current
    val contentResolver = context.contentResolver

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp)
    ) {
        item { ShowCount(allItems.size) }
        items(allItems) { item ->
            StoreBoxShow(navController, item = item)
        }
    }

}

@Composable
private fun ShowCount(productCount: Int) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Text(
            text = "${digitByLocate(productCount.toString())} کالا",
            style = Typography.h5,
            color = MaterialTheme.colors.unSelectedBottomBar,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(loginBoxTopColor)
            .padding(20.dp)
    )
    Spacer(modifier = Modifier.height(20.dp))
}

