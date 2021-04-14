package com.bme.aut.craftedcocktails.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(private val detailsScreenPresenter: DetailsScreenPresenter) :
    RainbowCakeViewModel<DetailsScreenViewState>(
        Initial
    ) {

    fun getCocktailDetails() {
        // TODO("Not yet implemented")
    }
}