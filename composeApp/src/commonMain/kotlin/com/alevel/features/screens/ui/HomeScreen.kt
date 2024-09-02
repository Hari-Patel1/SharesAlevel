package com.alevel.features.screens.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.alevel.features.screens.models.HomeModel
import com.alevel.theme.Black
import com.alevel.theme.DarkNavigationBarColour
import com.alevel.theme.LightNavigationBarColour

class HomeScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val uiColour = if (isSystemInDarkTheme()) Color.White else Black
        val model = HomeModel()

        var welcomeText by remember { mutableStateOf("Welcome Back, ${model.user()}") }
        var isIconAtStart by remember { mutableStateOf(false) }
        var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

        // Define the scroll behavior for the TopAppBar
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

        // Animating the horizontal position of the icon
        val iconOffset by animateDpAsState(
            targetValue = if (isIconAtStart) 0.dp else 310.dp,
            animationSpec = tween(durationMillis = 300)
        )

        // Animating the width of the search bar
        val searchBarWidth by animateDpAsState(
            targetValue = if (iconOffset == 0.dp) 300.dp else 0.dp, // Expand when iconOffset is 0
            animationSpec = tween(durationMillis = 300)
        )

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
                            // Search Bar
                            TextField(
                                //passing certain params such as label and text colours helps the textfield blend in better
                                value = searchQuery,
                                onValueChange = { newValue -> searchQuery = newValue },
                                placeholder = { Text("Search the markets") },
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    disabledContainerColor = Color.Transparent,
                                    focusedLabelColor = uiColour,
                                    unfocusedLabelColor = uiColour,
                                ),
                                textStyle = TextStyle(color = uiColour),
                                modifier = Modifier
                                    .width(searchBarWidth)
                                    .clip(RoundedCornerShape(10.dp)),
                                singleLine = true
                            )

                            // Search Icon
                            IconButton(
                                modifier = Modifier
                                    .offset(x = iconOffset) // Animate horizontal position
                                    .padding(end = 10.dp),
                                onClick = {
                                    isIconAtStart = true // Move the icon to the start
                                    welcomeText = "" // Clear the welcome text
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Sharp.Search,
                                    contentDescription = null,
                                    tint = uiColour
                                )
                            }

                            // Welcome Text
                            if (welcomeText.isNotEmpty()) {
                                Text(
                                    textAlign = TextAlign.Start,
                                    text = welcomeText,
                                    color = uiColour
                                )
                            }
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
                                text = "Stock #$index",
                                fontSize = 15.sp,
                                color = uiColour,
//                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal =  16.dp)
                                    .padding(vertical = 15.dp)
                            )

                            HorizontalDivider(color = uiColour.copy(0.5f), thickness = 1.dp, modifier = Modifier.padding(horizontal = 18.dp))

                        }
                    }
                }
            }
        )
    }
}
