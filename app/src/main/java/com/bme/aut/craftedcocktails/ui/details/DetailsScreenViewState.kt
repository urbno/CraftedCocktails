package com.bme.aut.craftedcocktails.ui.details

import com.bme.aut.craftedcocktails.model.Cocktail

sealed class DetailsScreenViewState

object Initial : DetailsScreenViewState()

object Loading : DetailsScreenViewState()

data class DetailsReady(val result: Cocktail) : DetailsScreenViewState()

object DatabaseError : DetailsScreenViewState()