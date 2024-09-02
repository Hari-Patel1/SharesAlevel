package com.alevel.features.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.SlideTransition
import com.alevel.features.screens.ui.HomeScreen

class NavigationScreen : Screen {
    @Composable
    override fun Content() {
        Navigator(HomeScreen()) { navigator ->
            SlideTransition(navigator)
            Scaffold(
                content = { CurrentScreen() },
                bottomBar = { NavBar() }
            )
        }
    }
}
