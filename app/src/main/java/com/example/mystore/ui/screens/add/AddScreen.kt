package com.example.mystore.ui.screens.add

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material3.Button
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mystore.R
import com.example.mystore.data.model.Product2
import com.example.mystore.navigation.Screen
import com.example.mystore.ui.components.HeaderTextApp
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.h5
import com.example.mystore.util.Constants.PHOTO_ARRAY
import com.example.mystore.util.Constants.PHOTO_INDEX
import com.example.mystore.viewModel.DataBaseViewModel2
import com.example.mystore.viewModel.DataStoreViewModel

@Composable
fun AddScreen(
    navController: NavController,
    viewModel: DataBaseViewModel2 = hiltViewModel(),
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
){
    var name by remember{ mutableStateOf("")}
    var price by remember{ mutableStateOf("")}
    var discount by remember{ mutableStateOf("")}
    var count by remember{ mutableStateOf("")}
    var des by remember{ mutableStateOf("")}
    val context = LocalContext.current
    var selectImage by remember { mutableStateOf("") }
    var colorSelected = if (selectImage == "") Color(0xFFF44336) else Color(0xFF4CAF50)
    var textSelected = if (selectImage == "") "انتخاب تصویر" else "تعویض تصویر"

    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        HeaderTextApp()
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{MyEditText(value = name, placeholder = "نام کالا", onValueChange = {name = it})}
            item{MyEditText(value = price, placeholder = "قیمت", onValueChange = {price = it}, isPhoneKeyBoard = true)}
            item{MyEditText(value = discount, placeholder = "مقدار تخفیف", onValueChange = {discount = it} , isPhoneKeyBoard = true)}
            item{MyEditText(value = count, placeholder = "تعداد", onValueChange = {count = it}, isPhoneKeyBoard = true)}
            item{MyEditText(value = des, placeholder = "توضیحات", onValueChange = {des = it}, modifier = Modifier.height(200.dp))}
            item{
                AddButton(colorSelected,textSelected) {
                    selectImage = it
                }
            }
            item{AddButton {
                if (name != "" && price != "" && discount != "" && count != "" && des != ""){
                    if (discount.toInt() <= 100){
                        if (selectImage != ""){
                            viewModel.insertProduct(
                                Product2(
                                    name = name,
                                    price = price.toLong(),
                                    discountPercent = discount.toInt(),
                                    count = count.toInt(),
                                    image = PHOTO_ARRAY[PHOTO_INDEX].toString(),
                                    description = des
                                )
                            )
                            if (PHOTO_INDEX < 3){
                                PHOTO_INDEX++
                            }else PHOTO_INDEX = 0
                            dataStoreViewModel.setPhotoIndex(PHOTO_INDEX)

                            navController.navigate(Screen.Home.route){
                                popUpTo(Screen.Add.route){
                                    inclusive = true
                                }
                            }
                        }else{
                            Toast.makeText(context , "لطفا یک عکس انتخاب کنید.",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(context , "مقدار تخفیف نامعتبر است لطفا دوباره وارد کنید.",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context , "لطفا فیلد های خالی را پر کنید.",Toast.LENGTH_SHORT).show()
                }
            }}
        }
    }
}

@Composable
private fun AddButton(
    color: Color,
    text: String,
    onClick: (String) -> Unit,
) {
    var selectImage by remember { mutableStateOf<Uri?>(null) }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            selectImage = uri
        }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 5.dp)
        .padding(horizontal = 30.dp), horizontalArrangement = Arrangement.Start) {
        Button(
            onClick = {
                galleryLauncher.launch("image/*")
                onClick(selectImage.toString())
            },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text(
                text = text,
                style = Typography.h5,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}

@Composable
fun ImagePicker1(viewModel: DataBaseViewModel2 = hiltViewModel()) {
    var selectImage by remember {
        mutableStateOf<Uri?>(null)
    }
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            selectImage = uri
        }
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material.Button(
            onClick = { galleryLauncher.launch("image/*") },
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
        ) {
            Text(text = "Pick Image From Gallery")
        }
        var painter : Painter = painterResource(id = R.drawable.basket)
        if (selectImage != null){
            painter =rememberImagePainter(data = selectImage)
        }
        LazyColumn() {
            item {
                androidx.compose.material.Button(
                    onClick = {
                        if (selectImage != null){
                                viewModel.insertProduct(
                                Product2(
                                    name = "چای داغ بنوشید و از آن لذت کامل ببرید . ",
                                    discountPercent = 10,
                                    image = painter.toString(),
                                    count = 10,
                                    price = 30000,
                                    description = ""
                                )
                            )
                            Toast.makeText(context ,"ذخیره شد.",Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(context , "لطفا یک عکس انتخاب کنید.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp)
                ) {
                    Text(text = "save in dataBase")
                }
            }
        }

    }

}
