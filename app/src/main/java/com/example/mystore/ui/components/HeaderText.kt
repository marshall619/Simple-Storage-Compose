package com.example.mystore.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mystore.ui.theme.dyna
import com.example.mystore.ui.theme.loginBoxTopColor

@Composable
fun HeaderTextApp(

    modifier: Modifier = Modifier,

    ) {

    Column(

        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(loginBoxTopColor)
            .padding(horizontal = 10.dp)
            .padding(top = 20.dp , bottom = 10.dp),

        ) {

        Row(

            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start

            ) {

            Text(

                text = "Jelve Store",
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = dyna

            )

        }

    }

}