package com.example.mystore.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mystore.ui.theme.LocalSpacing
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.darkText
import com.example.mystore.ui.theme.h3
import com.example.mystore.ui.theme.h4
import com.example.mystore.ui.theme.h5
import com.example.mystore.ui.theme.searchBarBg
import com.example.mystore.ui.theme.semiDarkText
import com.example.mystore.R

@Composable
fun DescriptionScreen(
    navController: NavController,
    description: String,
) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = LocalSpacing.current.medium)
                    .clickable {
                        navController.popBackStack()
                    }
                    .size(24.dp)

            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.review),
                textAlign = TextAlign.Start,
                style = Typography.h3,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.darkText,
            )

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(MaterialTheme.colors.searchBarBg)
        )


        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalSpacing.current.semiMedium),
                text = stringResource(id = R.string.product_introduce),
                textAlign = TextAlign.Start,
                style = Typography.h4,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.darkText,
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(LocalSpacing.current.semiMedium),
                text = description,
                textAlign = TextAlign.Start,
                style = Typography.h5,
                color = MaterialTheme.colors.semiDarkText,
            )
        }

    }

}