package com.bme.aut.craftedcocktails.ui.details

import com.bme.aut.craftedcocktails.domain.CocktailsInteractor
import javax.inject.Inject

class DetailsScreenPresenter @Inject constructor(
    private val cocktailsInteractor: CocktailsInteractor
) {

    suspend fun getCocktailDetails() {
        // TODO("Not yet implemented")
    }
}