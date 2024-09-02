package com.alevel.features.screens.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.alevel.theme.Black
import com.alevel.theme.DarkNavigationBarColour
import com.alevel.theme.LightNavigationBarColour

class SettingsScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val uiColour = if (isSystemInDarkTheme()) Color.White else Black


        // Define the scroll behavior for the TopAppBar
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


        Scaffold(
            // Apply the nestedScroll modifier to handle the scroll behavior and hide top bar upon scroll
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    // Apply the scroll behavior to the top bar
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Settings",
                                color = uiColour,
                                fontSize = 20.sp
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = if (isSystemInDarkTheme()) DarkNavigationBarColour else LightNavigationBarColour,
                        scrolledContainerColor = if (isSystemInDarkTheme()) DarkNavigationBarColour else LightNavigationBarColour
                    ),
                    scrollBehavior = scrollBehavior
                )
            },
            content = { paddingValues ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 100.dp)
                        .padding(paddingValues) // Use paddingValues to avoid overlap with TopAppBar

                ) {

                    items(50) { index ->
                        Text(
                            text = "Item #$index",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .clickable{}
                        )
                    }
                }
            }
        )
    }
}
