package com.alevel.features.auth.models


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.ScreenModel

class LoginModel () : ScreenModel {
    //buttons ONLY  with functionality
    @Composable
    fun onEmailValueChange() {
        val email = remember { mutableStateOf("") }
    }

    @Composable
    fun onPasswordValueChange() {
        val password = remember { mutableStateOf("") }

    }



}