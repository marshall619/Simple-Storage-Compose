package com.example.mystore.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mystore.R

val gothicA1 = FontFamily(
    listOf(
        Font(R.font.gothica1_regular, FontWeight.Normal),
        Font(R.font.gothica1_medium, FontWeight.Medium),
        Font(R.font.gothica1_semibold, FontWeight.SemiBold),
        Font(R.font.gothica1_bold, FontWeight.Bold),
        Font(R.font.gothica1_black, FontWeight.Black),
    )
)
val dyna = FontFamily(
    Font(R.font.dynabould, FontWeight.Bold),
    Font(R.font.dynamediom, FontWeight.Medium),
    Font(R.font.dynareg, FontWeight.Normal),
    Font(R.font.dynasimibold, FontWeight.SemiBold)
)
val incon = FontFamily(
    Font(R.font.inconsolatasimple, FontWeight.Normal)
)
val persionFont = FontFamily(
    Font(R.font.vazirmedium, FontWeight.Normal)
)

val iranikan_font_medium = FontFamily(
    Font(R.font.iranyekanmedium)
)
val iranikan_font_bold = FontFamily(
    Font(R.font.iranyekanbold)
)
val iranikan_font_standard = FontFamily(
    Font(R.font.iranyekan)
)
val Typography.body1 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_medium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.sp
    )

val Typography.h1 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 25.sp
    )
val Typography.h2 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 25.sp
    )
val Typography.h3 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 25.sp
    )
val Typography.h4 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 25.sp
    )
val Typography.h6 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Medium,
        lineHeight = 25.sp
    )

val Typography.h5 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 25.sp
    )

val Typography.body2 : TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = iranikan_font_standard,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 25.sp
    )