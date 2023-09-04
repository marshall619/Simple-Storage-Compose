package com.example.mystore.ui.screens.claim

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mystore.data.model.Product2
import com.example.mystore.navigation.Screen
import com.example.mystore.ui.components.HeaderTextApp
import com.example.mystore.ui.screens.add.MyEditText
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.h5
import com.example.mystore.viewModel.DataBaseViewModel2

@Composable
fun ClaimScreen(
    navController: NavController,
    viewModel: DataBaseViewModel2 = hiltViewModel(),
) {
    val allItems by viewModel.allProducts.collectAsState(emptyList())
    var id by remember { mutableStateOf("") }
    var count by remember { mutableStateOf("") }
    var isIdFounded = false
    val context = LocalContext.current
    var itemFounded by remember {
        mutableStateOf<Product2>(
            Product2(
                discountPercent = 10,
                name = "",
                price = 30000,
                image = "",
                count = 2,
                description = ""
            )
        )
    }

    if (id != "") {
        for (element in allItems) {
            if (id.toInt() == element.id) {
                isIdFounded = true
                itemFounded = element
            }
        }
    }

    Column() {
        HeaderTextApp()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyEditText(
                value = id,
                placeholder = "کد کالا",
                onValueChange = { id = it },
                isPhoneKeyBoard = true
            )
            MyEditText(
                value = count,
                placeholder = "تعداد",
                onValueChange = { count = it },
                isPhoneKeyBoard = true
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ClaimButton(Color(0xFFF44336), "حذف کالا") {
                    if (isIdFounded) {
                        viewModel.deleteProductById(id.toInt())
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Claim.route) {
                                inclusive = true
                            }
                        }
                    } else {
                        Toast.makeText(
                            context, "کد کالای مورد نظر یافت نشده لطفا دوباره وارد کنید.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                ClaimButton(Color(0xFF03A9F4), "برداشت") {
                    if (isIdFounded) {
                        if (itemFounded.count >= count.toInt()) {
                            viewModel.updateProductById(
                                (itemFounded.count - count.toInt()),
                                itemFounded.id
                            )
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Claim.route) {
                                    inclusive = true
                                }
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "مقدار برداشتی از موجودی بیشتر است لطفا مقدار جدیدی را وارد کنید.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        Toast.makeText(
                            context, "کد کالای مورد نظر یافت نشده لطفا دوباره وارد کنید.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                ClaimButton(Color(0xFF4CAF50), "افزودن") {
                    if (isIdFounded) {
                        viewModel.updateProductById(
                            (itemFounded.count + count.toInt()),
                            itemFounded.id
                        )
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Claim.route) {
                                inclusive = true
                            }
                        }
                    } else {
                        Toast.makeText(
                            context, "کد کالای مورد نظر یافت نشده لطفا دوباره وارد کنید.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

}

@Composable
private fun ClaimButton(
    color: Color,
    text: String,
    onClick: () -> Unit,
) {
    Button(onClick = { onClick() }, colors = ButtonDefaults.buttonColors(color)) {
        Text(
            text = text,
            style = Typography.h5,
            fontWeight = FontWeight.Medium,
        )
    }
}

