package com.bme.aut.craftedcocktails.ui.about

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AboutScreenViewModel @Inject constructor(private val aboutScreenPresenter: AboutScreenPresenter) :
    RainbowCakeViewModel<AboutScreenViewState>(Initial) {

    fun getAboutInfo() {
        // TODO("Not yet implemented")
    }
}