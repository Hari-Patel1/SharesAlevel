package com.alevel.features.search.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.alevel.features.screens.models.HomeModel
import com.alevel.features.search.models.SearchModel
import com.alevel.theme.Black
import kotlinx.coroutines.Delay
import kotlinx.coroutines.InternalCoroutinesApi

class SearchScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val DarkNavigationBarColour = Color(0xFF1e293b)
        val LightNavigationBarColour = Color(0xFFbfdbfe)
        val uiColour = if (isSystemInDarkTheme()) Color.White else Black
        val model = SearchModel()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        val navigator = LocalNavigator.currentOrThrow
        val isVisible = remember { mutableStateOf(false) }

        isVisible.value = navigator.lastItem::class == this::class

        Scaffold(
            // Apply the nestedScroll modifier to handle the scroll behavior and hide top bar upon scroll
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    title = {

                        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier) {

                            IconButton(
                                onClick = {  },
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Search,
                                    contentDescription = null,
                                    tint = uiColour

                                )
                            }

                            // Using AnimatedVisibility with expandHorizontally
                            AnimatedVisibility(
                                visible = isVisible.value,
                                enter = expandHorizontally(
                                    initialWidth = { 0 }// Start from 0 width
                                    // Optional: You can specify an animation spec here, e.g., tween()
                                ) + fadeIn(), // You can combine with other animations
                                exit = fadeOut() // Optional: Define exit animations
                            ) {

                                SearchBar(
                                    query = "searchText",//text showed on SearchBar
                                    onQueryChange = {}, //update the value of searchText
                                    onSearch = {}, //the callback to be invoked when the input service triggers the ImeAction.Search action
                                    active = true, //whether the user is searching or not
                                    onActiveChange = {  }, //the callback to be invoked when this search bar's active state is changed
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 10.dp)
                                ){}

//                                TextField(
//                                    //passing certain params such as label and text colours helps the textfield blend in better
//                                    value = model.Search().value,
//                                    onValueChange = { },
//                                    label = { Text("Username or Email", color = uiColour) },
//                                    colors = TextFieldDefaults.colors(
//                                        focusedContainerColor = Color.Transparent,
//                                        unfocusedContainerColor = Color.Transparent,
//                                        disabledContainerColor = Color.Transparent,
//                                        focusedLabelColor = uiColour,
//                                        unfocusedLabelColor = uiColour,
//                                    ),
//                                    textStyle = TextStyle(color = uiColour),
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(bottom = 10.dp)
//                                        .padding(end = 20.dp)
//                                )
                            }

                        }

                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = if (isSystemInDarkTheme()) DarkNavigationBarColour else LightNavigationBarColour,
                        // Maintain consistent colors when scrolling
                        scrolledContainerColor = if (isSystemInDarkTheme()) DarkNavigationBarColour else LightNavigationBarColour
                    ),
                    scrollBehavior = scrollBehavior
                )
            },
            content = { paddingValues ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues) // Use paddingValues to avoid overlap with TopAppBar
                        .padding(bottom = 56.dp)
                ) {
                    items(50) { index ->
                        Text(
                            text = "Item #$index",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
            }
        )

    }
}




//class SearchScreen : Screen {
//@Composable
//override fun Content() {
//    val uiColour = if (isSystemInDarkTheme()) Color.White else Black
//    val visible = remember { mutableStateOf(false) }
//    val HomeModel = HomeModel()
//
//
//        // Using AnimatedVisibility with expandHorizontally
//        AnimatedVisibility(
//            visible = HomeModel.ScreenSetter().value,
//            enter = expandHorizontally(
//                initialWidth = { 0 }, // Start from 0 width
//                // Optional: You can specify an animation spec here, e.g., tween()
//            ) + fadeIn(), // You can combine with other animations
//            exit = fadeOut() // Optional: Define exit animations
//        ) {
//            TextField(
//                value = "Hello",
//                //passing certain params such as label and text colours helps the textfield blend in better
//                onValueChange = {  },
//                label = { Text("Username or Email", color = uiColour) },
//                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.Transparent,
//                    unfocusedContainerColor = Color.Transparent,
//                    disabledContainerColor = Color.Transparent,
//                    focusedLabelColor = uiColour,
//                    unfocusedLabelColor = uiColour,
//                ),
//                textStyle = TextStyle(color = uiColour),
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//    }
//}
