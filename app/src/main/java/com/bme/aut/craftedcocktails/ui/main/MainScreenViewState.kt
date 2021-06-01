package com.bme.aut.craftedcocktails.ui.main

import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.model.Response

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object Loading : MainScreenViewState()

data class DataReady(val result: ArrayList<Cocktail>) : MainScreenViewState()

object NetworkError : MainScreenViewState()

object DatabaseError : MainScreenViewState()