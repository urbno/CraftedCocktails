package com.bme.aut.craftedcocktails.ui.details

sealed class DetailsScreenViewState

object Initial : DetailsScreenViewState()

object Loading : DetailsScreenViewState()

data class DetailsReady(val result: String) : DetailsScreenViewState()

object NetworkError : DetailsScreenViewState()