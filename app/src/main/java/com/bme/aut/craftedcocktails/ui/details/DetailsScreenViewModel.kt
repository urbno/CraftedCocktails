package com.bme.aut.craftedcocktails.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.util.ItemConverter
import java.lang.Exception
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(private val detailsScreenPresenter: DetailsScreenPresenter) :
    RainbowCakeViewModel<DetailsScreenViewState>(
        Initial
    ) {

    fun getCocktailDetailsById(cocktailId: String) = execute {
        viewState = Loading
        viewState = try {
            var detailedCocktail = Cocktail()
            detailsScreenPresenter.getCocktailDetailsById(cocktailId).forEach { cocktailEntity ->
                detailedCocktail = ItemConverter.entityToModel(cocktailEntity)
            }
            DetailsReady(detailedCocktail)
        } catch (e: Exception) {
            DatabaseError
        }
    }
}