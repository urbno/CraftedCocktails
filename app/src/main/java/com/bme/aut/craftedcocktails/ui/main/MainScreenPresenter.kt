package com.bme.aut.craftedcocktails.ui.main

import com.bme.aut.craftedcocktails.domain.CocktailsInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val cocktailsInteractor: CocktailsInteractor
) {

    suspend fun getCocktails() {
        // TODO("Not yet implemented")
    }
}
