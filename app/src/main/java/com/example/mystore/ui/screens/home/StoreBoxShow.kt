package com.example.mystore.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.mystore.R
import com.example.mystore.data.model.Product2
import com.example.mystore.navigation.Screen
import com.example.mystore.ui.theme.DigikalaDarkRed
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.body2
import com.example.mystore.ui.theme.h5
import com.example.mystore.ui.theme.namojod
import com.example.mystore.util.Constants.PHOTO_ARRAY
import com.example.mystore.util.Constants.PHOTO_INDEX
import com.example.mystore.util.DigitHelper.applyDiscount
import com.example.mystore.util.DigitHelper.digitByLocate
import com.example.mystore.util.DigitHelper.digitBySeparator
import com.example.mystore.viewModel.DataStoreViewModel

@Composable
fun StoreBoxShow(
    navController: NavController,
    item: Product2,
) {
    var haveDiscount = item.discountPercent > 0
    var arrangement = if (haveDiscount) Arrangement.SpaceBetween else Arrangement.End
    
    val countText = if (item.count > 0){
        "${digitByLocate(item.count.toString())} عدد در انبار موجود است."
    }else{
        "ناموجود"
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { navController.navigate(Screen.Des.route + "?description=${item.description}") }, verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.padding(top = 3.dp),horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = item.image.toInt()),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .width(90.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = "${digitByLocate(item.id.toString())}#",
                style = Typography.h5,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colors.DigikalaDarkRed
            )
        }


        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = item.name,
                style = Typography.h5,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = countText,
                style = Typography.h5,
                fontSize = 12.sp,
                color = namojod
            )



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = arrangement,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (haveDiscount) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(24.dp)
                            .background(
                                color = MaterialTheme.colors.DigikalaDarkRed,
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "${digitByLocate(item.discountPercent.toString())}%",
                            color = Color.White,
                            style = Typography.h5,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row {
                        Text(
                            text = digitByLocate(
                                digitBySeparator(
                                    applyDiscount(
                                        item.price,
                                        item.discountPercent
                                    ).toString()
                                )
                            ),
                            style = Typography.body2,
                            fontWeight = FontWeight.SemiBold,
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            modifier = Modifier
                                .size(6.dp)
                                .padding(horizontal = 4.dp)
                        )

                    }
                    if (haveDiscount) {
                        Text(
                            text = digitByLocate(digitBySeparator(item.price.toString())),
                            color = Color.LightGray,
                            style = Typography.body2,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }

            }
        }

    }
    Spacer(modifier = Modifier.height(5.dp))
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0x9A000000))
            .padding(20.dp)
    )

}
