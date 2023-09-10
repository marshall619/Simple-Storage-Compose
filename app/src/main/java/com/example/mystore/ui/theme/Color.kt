package com.example.mystore.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

//..... login colors
val loginBoxTopColor = Color(0xfff12711)
val loginBoxBottonColor = Color(0xfff5af19)
//box Background
val boxBackgroundinStore = Color(0xFFB8E6EC)
val namojod = Color(0xFFF73B00)
//next Button Color
val nextButtonColor1 = Color(0xff1c92d2)
val nextButtonColor2 = Color(0xFF8CC4CF)

val Colors.splashBg : Color
    @Composable
    get() = Color(0xffed1b34)

val Colors.selectedBottomBar : Color
    @Composable
    get() = if (isLight) Color(0xff43474c) else Color(0xffcfd4da)

val Colors.unSelectedBottomBar : Color
    @Composable
    get() = if (isLight) Color(0xffa4a1a1) else Color(0xff575a5e)


val Colors.bottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xFF303235)


val Colors.searchBarBg : Color
    @Composable
    get() = if (isLight) Color(0xFFF1F0EE) else Color(0xFF303235)

val Colors.darkText: Color
    @Composable
    get() = if (isLight) Color(0xFF414244) else Color(0xFFD8D8D8)

val Colors.amber: Color
    @Composable
    get() =  Color(0xffFFBF00)

val Colors.grayCategory: Color
    @Composable
    get() = Color(0xFFF1F0EE)

val Colors.DigikalaLightRed: Color
    @Composable
    get() = if (isLight) Color(0xffef4056) else Color(0xFF8D2633)

val Colors.DarkCyan: Color
    @Composable
    get() = Color(0xFF0fabc6)

val Colors.LightCyan: Color
    @Composable
    get() = Color(0xFF17bfd3)


val Colors.digikalaRed: Color
    @Composable
    get() = Color(0xFFed1b34)


val Colors.DigikalaDarkRed: Color
    @Composable
    get() = Color(0xFFe6123d)

val Colors.DigikalaLightGreen: Color
    @Composable
    get() = if (isLight) Color(0xff86bf3c) else Color(0xFF3A531A)

val Colors.settingArrow: Color
    @Composable
    get() = if (isLight) Color(0xff9e9fb1) else Color(0xFFd8d8d8)


val Colors.semiDarkText: Color
    @Composable
    get() = if (isLight) Color(0xFF5C5E61) else Color(0xFFD8D8D8)

val Colors.CursorColor : Color
    @Composable
    get() = Color(0xFF018577)

