package com.bme.aut.craftedcocktails.ui.main

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.util.ItemConverter
import timber.log.Timber
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
            val cocktail = mainScreenPresenter.getRandomCocktail().drinks?.get(0)!!
            randomCocktails.add(cocktail)
            mainScreenPresenter.insertCocktails(ItemConverter.modelToEntity(cocktail))
            Timber.d("$TAG network: $randomCocktails")
            val randomCocktailsDB = arrayListOf<Cocktail>()
            for (rCocktail in randomCocktails) {
                val dbCocktail = mainScreenPresenter.getSpecificCocktail(rCocktail.idDrink!!)
                dbCocktail.forEach {
                    randomCocktailsDB.add(ItemConverter.entityToModel(it))
                }
            }
            Timber.d("$TAG database: $randomCocktailsDB")
            DataReady(randomCocktails)
        } catch (e: Exception) {
            NetworkError
        }
    }

}