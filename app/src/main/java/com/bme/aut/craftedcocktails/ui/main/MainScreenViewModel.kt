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
            val databaseCocktails = mainScreenPresenter.getSavedCocktails()
            var cocktail: Cocktail
            if (databaseCocktails.size < 10) {
                for (i in 0..(10 - databaseCocktails.size)) {
                    cocktail = mainScreenPresenter.getRandomCocktail().drinks?.get(0)!!
                    Timber.d("$TAG network: $cocktail")
                    mainScreenPresenter.insertCocktails(ItemConverter.modelToEntity(cocktail))
                }
            }
            val cocktails = arrayListOf<Cocktail>()
            databaseCocktails.forEach {
                cocktails.add(ItemConverter.entityToModel(it))
            }
            Timber.d("$TAG database: $databaseCocktails")
            DataReady(cocktails)
        } catch (e: Exception) {
            NetworkError
        }
    }

    // region network

    fun searchCocktailByName(cocktailName: String) = execute {
        viewState = Loading
        viewState = try {
            val result = mainScreenPresenter.getCocktailByName(cocktailName).drinks?.get(0)!!
            DataReady(arrayListOf(result))
        } catch (e: Exception) {
            NetworkError
        }
    }

    // endregion network

    // region database

    fun deleteCocktailFromDatabase(cocktailId: String) = executeNonBlocking {
        mainScreenPresenter.deleteCocktail(cocktailId)
        viewState = Loading
        viewState = DataReady(arrayListOf())
    }

    fun deleteAllCocktails() = executeNonBlocking {
        mainScreenPresenter.deleteAllCocktails()
    }

    // endregion database

}