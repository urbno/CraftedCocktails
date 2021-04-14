package com.bme.aut.craftedcocktails.ui.about

import com.bme.aut.craftedcocktails.domain.CocktailsInteractor
import javax.inject.Inject

class AboutScreenPresenter @Inject constructor(private val cocktailsInteractor: CocktailsInteractor) {

    suspend fun getAboutInfo() {
        // TODO("Not yet implemented")
    }
}