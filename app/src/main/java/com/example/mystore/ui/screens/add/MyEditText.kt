package com.example.mystore.ui.screens.add

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mystore.ui.theme.CursorColor
import com.example.mystore.ui.theme.DarkCyan
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.h5
import com.example.mystore.ui.theme.searchBarBg
import com.example.mystore.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun MyEditText(
    value: String,
    placeholder:String,
    isPhoneKeyBoard : Boolean = false,
    modifier : Modifier = Modifier,
    onValueChange: (String) -> Unit
){
    TextField(
        value = value,
        onValueChange = {onValueChange(it)},
        modifier = modifier
            .fillMaxWidth()
            .height(92.dp)
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 24.dp
            ),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.searchBarBg,
            focusedIndicatorColor = MaterialTheme.colors.DarkCyan,
            unfocusedIndicatorColor =  MaterialTheme.colors.searchBarBg,
            cursorColor =  MaterialTheme.colors.CursorColor,
        ),
        placeholder = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ){
                Text(
                    text = placeholder,
                    style = Typography.h5,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPhoneKeyBoard) KeyboardType.Phone else KeyboardType.Text
        )
    )

}