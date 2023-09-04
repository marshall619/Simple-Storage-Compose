package com.example.mystore.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mystore.R
import com.example.mystore.ui.theme.Typography
import com.example.mystore.ui.theme.bottomBar
import com.example.mystore.ui.theme.h5
import com.example.mystore.ui.theme.loginBoxBottonColor
import com.example.mystore.ui.theme.namojod
import com.example.mystore.ui.theme.selectedBottomBar
import com.example.mystore.ui.theme.unSelectedBottomBar

@Composable
fun BottomNavigationBar(
    navController: NavController,
    iconSize : Dp = 26.dp,
    topRounded : Dp = 18.dp,
    onItemClick: (BottomNavItem) -> Unit
){
    val items = listOf(
        BottomNavItem(
            name = "خانه",
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.home1),
        ),
        BottomNavItem(
            name = "افزودن",
            route = Screen.Add.route,
            selectedIcon = painterResource(id = R.drawable.plus),
        ),
        BottomNavItem(
            name = "برداشت",
            route = Screen.Claim.route,
            selectedIcon = painterResource(id = R.drawable.basket),
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }

    if (showBottomBar) {
        BottomNavigation(
            modifier = Modifier.height(60.dp).clip(RoundedCornerShape(topEnd = topRounded, topStart = topRounded)),
            backgroundColor = loginBoxBottonColor,
            elevation = 5.dp
        ) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (selected) {
                                Icon(
                                    modifier = Modifier.size(iconSize),
                                    painter = item.selectedIcon,
                                    contentDescription = item.name,
                                    tint = Color.Black
                                )
                            } else {
                                Icon(
                                    modifier = Modifier.size(iconSize),
                                    painter = item.selectedIcon,
                                    contentDescription = item.name,
                                    tint = Color(0x81000000)
                                )
                            }
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                style = Typography.h5,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp),
                                color = Color(0x81000000)
                            )
                        }
                    }
                )
            }
        }
    }
}