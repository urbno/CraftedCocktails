package com.bme.aut.craftedcocktails

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.bme.aut.craftedcocktails.ui.main.MainScreenFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            navigator.add(MainScreenFragment())
        }
    }
}