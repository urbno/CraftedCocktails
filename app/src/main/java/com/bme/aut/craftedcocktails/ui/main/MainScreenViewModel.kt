package com.bme.aut.craftedcocktails.ui.main

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.model.Response
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {

    private val TAG = MainScreenViewModel::class.java.simpleName

    class NetworkStatusEvent(val networkType: String) : OneShotEvent

    fun loadCocktails() = execute {
        viewState = Loading
        viewState = try {
            val randomCocktails = arrayListOf<Cocktail>()
            for (i in 1..3) {
                randomCocktails.add(mainScreenPresenter.getRandomCocktail().drinks?.get(0)!!)
            }
            Timber.d("$TAG $randomCocktails")
            DataReady(randomCocktails)
        } catch (e: Exception) {
            NetworkError
        }
    }

}