package com.bme.aut.craftedcocktails.ui.main

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.bme.aut.craftedcocktails.data.CocktailEntity
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.util.ItemConverter
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
                val cocktail = mainScreenPresenter.getRandomCocktail().drinks?.get(0)!!
                randomCocktails.add(cocktail)
                mainScreenPresenter.insertCocktails(ItemConverter.modelToEntity(cocktail))
            }
            Timber.d("$TAG network: $randomCocktails")
            val randomCocktailsDB = arrayListOf<Cocktail>()
            for (cocktail in randomCocktails) {
                val dbCocktail = mainScreenPresenter.getSpecificCocktail(cocktail.idDrink!!)
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