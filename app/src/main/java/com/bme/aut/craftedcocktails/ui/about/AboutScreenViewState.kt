package com.bme.aut.craftedcocktails.ui.about

sealed class AboutScreenViewState

object Initial : AboutScreenViewState()

object Loading : AboutScreenViewState()

data class AboutReady(val result: String) : AboutScreenViewState()