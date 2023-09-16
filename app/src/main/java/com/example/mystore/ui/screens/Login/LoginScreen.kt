package com.example.mystore.ui.screens.Login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mystore.R
import com.example.mystore.navigation.Screen
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.dyna
import com.example.mystore.ui.theme.h6
import com.example.mystore.ui.theme.incon
import com.example.mystore.ui.theme.iranikan_font_bold
import com.example.mystore.ui.theme.iranikan_font_standard
import com.example.mystore.ui.theme.loginBoxBottonColor
import com.example.mystore.ui.theme.loginBoxTopColor
import com.example.mystore.util.Constants.Password
import com.example.mystore.util.Constants.UserName
import com.example.mystore.viewModel.DataStoreViewModel
//login page
@Composable
fun LoginScreen(navController: NavController, viewModel: DataStoreViewModel = hiltViewModel()) {

    var isSignedIn = viewModel.getLaunchState() == 1
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEBEBEB)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Login_Top_Box(modifier = Modifier.fillMaxHeight(0.4f))
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        LoginTextFeild(icon = painterResource(id = R.drawable.user), textlable = "user") {
            username = it
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        LoginTextFeild(
            icon = painterResource(id = R.drawable.key),
            textlable = "password",
            isItPasswordText = true,
            iconsize = 22
        ) {
            password = it
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        if (!isSignedIn) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = null,
                    tint = Color(0xA6000000),
                    modifier = Modifier.size(5.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "توجه داشته باشد که اگر اولین بار است که لاگین می کنید لطفا نام کاربری و رمز عبور جدیدی وارد کنید .",
                    style = Typography.h6,
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                    color = Color(0xA6000000)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        GradientButton(
            text = "login",
            onClick = {
                if (isSignedIn) {
                    UserName = viewModel.getUserName().toString()
                    Password = viewModel.getUserPassword().toString()
                    if (username == UserName && password == Password) {
                        navController.navigate(Screen.Home.route){
                            popUpTo(Screen.Login.route){
                                inclusive = true
                            }
                        }
                    } else {
                        if (username.isNotBlank() && password.isNotBlank()) {
                            Toast.makeText(
                                context,
                                "نام کاربری یا پسورد اشتباه است!! لطفا دوباره وارد کنید.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else Toast.makeText(
                            context,
                            "لطفا فیلد های خالی را پر کنید.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    if (username.isNotBlank() && password.isNotBlank()) {
                        viewModel.setUserName(username)
                        viewModel.setUserPassword(password)
                        viewModel.setLaunchState(1)
                        navController.navigate(Screen.Home.route)
                    } else {
                        Toast.makeText(
                            context,
                            "لطفا فیلد های خالی را پر کنید.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            },
            textColor = Color.White
        )
    }

}

@Composable
fun Login_Top_Box(

    modifier: Modifier,
    fontsize: Int = 40,
    BrushStart: Color = loginBoxTopColor,
    BrushEnd: Color = loginBoxBottonColor,
    TextFontFamily: FontFamily = dyna,
    roundCornerRadius: Int = 100,
    fontcolor: Color = Color.White,

    ) {

    Column(

        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = roundCornerRadius.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        BrushStart,
                        BrushEnd,
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(

            text = "WellCome To",
            color = fontcolor,
            fontSize = fontsize.sp,
            fontFamily = dyna

        )



        Text(

            text = "Jelve Store",
            color = fontcolor,
            fontSize = 30.sp,
            fontFamily = dyna

        )

    }

}

@Composable
fun LoginTextFeild(

    icon: Painter,
    textlable: String,
    iconsize: Int = 25,
    isItPasswordText: Boolean = false,
    onvalueChange: (String) -> Unit,

    ) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(

        value = text,
        onValueChange = { text = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.DarkGray,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.DarkGray,
            unfocusedLabelColor = Color.DarkGray
        ),
        label = { Text(text = textlable, fontSize = 15.sp, fontFamily = incon) },
        leadingIcon = {
            Icon(
                painter = icon,
                contentDescription = textlable,
                modifier = Modifier.size(iconsize.dp)
            )
        },
        modifier = Modifier.clip(RoundedCornerShape(24.dp)),
        visualTransformation = if (isItPasswordText) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )

    )
    onvalueChange(text)

}

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    textColor: Color,
    roundCornerShape: Dp = 30.dp,
    textsize: Int = 25,
) {

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .clip(RoundedCornerShape(roundCornerShape))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        loginBoxTopColor,
                        loginBoxBottonColor
                    )
                )
            )
            .clickable { onClick() }
            .padding(10.dp),
        contentAlignment = Alignment.Center

    ) {

        Text(text = text, color = textColor, fontSize = textsize.sp, fontFamily = dyna)

    }

}
