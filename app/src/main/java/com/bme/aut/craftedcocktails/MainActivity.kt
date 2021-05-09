package com.bme.aut.craftedcocktails

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.bme.aut.craftedcocktails.ui.main.MainScreenFragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : SimpleNavActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            navigator.add(MainScreenFragment())
        }
        firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.setUserProperty("user_name", "Urbán Norbert")
    }
}