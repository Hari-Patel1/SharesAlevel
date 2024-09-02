package com.alevel.features.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.FadeTransition
import com.alevel.features.screens.ui.HomeScreen
import com.alevel.features.screens.ui.MachineLearning
import com.alevel.features.screens.ui.PortfolioScreen
import com.alevel.features.screens.ui.SettingsScreen
import com.alevel.theme.Black
import com.alevel.theme.DarkNavigationBarColour
import com.alevel.theme.LightNavigationBarColour
import org.jetbrains.compose.resources.painterResource
import sharesapp.composeapp.generated.resources.Res
import sharesapp.composeapp.generated.resources.machine_learning_icon
import sharesapp.composeapp.generated.resources.machine_learning_icon_outlined


@Composable
fun NavBar () {
    val uiNavBarColour = if (isSystemInDarkTheme()) DarkNavigationBarColour else LightNavigationBarColour
    val uiColourButtons = if (isSystemInDarkTheme()) Color.Gray else Black
    val navigator = LocalNavigator.currentOrThrow
    var selectedIndex by remember { mutableIntStateOf(0) }




    Box(contentAlignment = Alignment.BottomCenter) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Padding around the navigation bar
                .background(
                    color = uiNavBarColour,
                    shape = RoundedCornerShape(20.dp) // Corner radius of 20.dp
                ),
            containerColor = Color.Transparent // Set to Transparent to avoid conflict with the background
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,){
                Icon(
                    imageVector = if (selectedIndex == 0) Icons.Filled.Home else Icons.Outlined.Home,
                    contentDescription = "Home NavBar icon",
                    tint = uiColourButtons,
                    modifier = Modifier
                        .padding(all = 18.dp)
                        .size(25.dp)
                        .clickable {
                            selectedIndex = 0
                            navigator.push(HomeScreen())  }

                )

                Icon(
                    painter = painterResource(if (selectedIndex == 1) Res.drawable.machine_learning_icon else Res.drawable.machine_learning_icon_outlined),
                    contentDescription = "Stock prediction NavBar icon",
                    tint = uiColourButtons,
                    modifier = Modifier
                        //since this .svg file is custom made and imported as .xml, we need to add custom padding to align it with the other icons in the NavBar
                        .padding(top = 13.dp)
                        .size(35.dp)
                        .clickable {
                            selectedIndex = 1
                            navigator.push(MachineLearning()) }
                )



                Icon(
                    imageVector = if (selectedIndex == 2) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                    contentDescription = "Portfolio NavBar icon",
                    tint = uiColourButtons,
                    modifier = Modifier
                        .padding(all = 18.dp)
                        .size(25.dp)
                        .clickable {
                            selectedIndex = 2
                            navigator.push(PortfolioScreen())}
                )


                Icon(
                    imageVector = if (selectedIndex == 3) Icons.Filled.Settings else Icons.Outlined.Settings,
                    contentDescription = "Settings NavBar icon",
                    tint = uiColourButtons,
                    modifier = Modifier
                        .padding(all = 18.dp)
                        .size(25.dp)
                        .clickable {
                            selectedIndex = 3
                            navigator.push(SettingsScreen())
                        }
                )
            }
        }
    }
}