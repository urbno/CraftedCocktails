package com.bme.aut.craftedcocktails.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    init {
        execute { loadCocktails() }
    }

    private suspend fun loadCocktails() {
        // TODO("Not yet implemented")
    }

}