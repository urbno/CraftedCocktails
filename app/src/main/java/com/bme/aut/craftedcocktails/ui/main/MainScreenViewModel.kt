package com.bme.aut.craftedcocktails.ui.main

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    class NetworkStatusEvent(val networkType: String) : OneShotEvent

    init {
        execute { loadCocktails() }
    }

    fun loadCocktails() = execute {
        viewState = Loading
        viewState = try {
            val randomCocktails = mainScreenPresenter.getRandomCocktail()
            Timber.d("$TAG $randomCocktails")
            DataReady(randomCocktails)
        } catch (e: Exception) {
            NetworkError
        }
    }

}