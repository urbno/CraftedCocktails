package com.bme.aut.craftedcocktails.ui.main

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object Loading : MainScreenViewState()

data class DataReady(val result: String) : MainScreenViewState()

object NetworkError : MainScreenViewState()