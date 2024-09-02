package com.alevel.features.screens.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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

class MachineLearning : Screen {
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
                                text = "Stock Predictor",
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
                        Box(modifier = Modifier.clickable {  }) {
                            Text(
                                text = "Added Stock #$index",
                                fontSize = 20.sp,
                                color = uiColour,
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal =  16.dp)
                                    .padding(vertical = 20.dp)
                                )

                            HorizontalDivider(color = uiColour.copy(0.5f), thickness = 1.dp, modifier = Modifier.padding(horizontal = 18.dp))

                        }
                    }
                        }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 90.dp)
                ) {
                    FloatingActionButton(
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .align(Alignment.BottomEnd),
                        containerColor = if (isSystemInDarkTheme()) DarkNavigationBarColour else LightNavigationBarColour,
                        contentColor = uiColour,
                        onClick = { /* TODO: Add functionality */ },

                        ) {

                        Row (
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(10.dp)

                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Outlined.Create, contentDescription = "Floating Action Button"
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(text = "Add a stock to predict")
                        }


                    }
                }
            }
        )
    }
}
