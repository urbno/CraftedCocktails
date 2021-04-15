package com.bme.aut.craftedcocktails.ui.main

import com.bme.aut.craftedcocktails.model.Response

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object Loading : MainScreenViewState()

data class DataReady(val result: Response) : MainScreenViewState()

object NetworkError : MainScreenViewState()