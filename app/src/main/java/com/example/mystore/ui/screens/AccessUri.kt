package com.example.mystore.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mystore.viewModel.DataBaseViewModel2


@Composable
fun AccessUri(viewModel: DataBaseViewModel2 = hiltViewModel()) {
    val allProducts by viewModel.allProducts.collectAsState(emptyList())
    if (allProducts.isNotEmpty()) {
        Column() {
            allProducts.forEach { item ->
                Image(
                    painter = rememberAsyncImagePainter(model = "https://upload.wikimedia.org/wikipedia/commons/0/07/Honeycrisp-Apple.jpg"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .clickable { },
                    contentScale = ContentScale.FillBounds
                )
                Text(text = item.image)
            }
        }
    }

}

