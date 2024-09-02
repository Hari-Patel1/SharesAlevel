package com.alevel.features.search.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.ScreenModel

class SearchModel : ScreenModel {

    @Composable
    fun Search(): MutableState<String> {
        val Search = remember { mutableStateOf("") }
        return Search
    }
    @Composable
    fun IsVisible(): MutableState<Boolean> {
        val isVisible = remember { mutableStateOf(false) }
        return isVisible
    }

}