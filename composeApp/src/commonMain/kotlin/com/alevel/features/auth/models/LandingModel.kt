package com.alevel.features.auth.models

import cafe.adriel.voyager.core.model.ScreenModel

class LandingModel () : ScreenModel {

    fun onGoogleLoginClick() {
        print("google login clicked")
    }

    fun onFacebookLoginClick() {
        print("facebook login clicked")
    }
}