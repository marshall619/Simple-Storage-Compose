package com.example.mystore.ui.screens.add

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystore.ui.theme.nextButtonColor1
import com.example.mystore.ui.theme.nextButtonColor2
import com.example.mystore.ui.theme.persionFont

@Composable
fun AddButton(
    onclick: () -> Unit,
) {
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        nextButtonColor1,
                        nextButtonColor2
                    )
                )
            )
            .clickable {
                onclick()
            }
            .padding(10.dp),
        contentAlignment = Alignment.Center

    ) {

        Text(

            text = "افزودن",
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = persionFont

        )
    }
}