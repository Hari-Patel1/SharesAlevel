package com.alevel

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import com.alevel.features.auth.ui.LandingScreen
import com.alevel.theme.MyApplicationTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            //wrap the landing screen with navigator so that it is accessible throughout the screens
            //uses the navigator to start at the landing screen
            Navigator(
                LandingScreen(/*TODO*/) //will make if if the user is logged in, the navigator takes user to home screen instead
            ) {navigator -> FadeTransition(navigator)  }

//            if (isSystemInDarkTheme()) { SideEffect {  } }
        }
    }
}