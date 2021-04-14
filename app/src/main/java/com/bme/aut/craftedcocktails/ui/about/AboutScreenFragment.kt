package com.bme.aut.craftedcocktails.ui.about

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import com.bme.aut.craftedcocktails.R

class AboutScreenFragment : RainbowCakeFragment<AboutScreenViewState, AboutScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_about

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO("Not yet implemented")
    }

    override fun onEvent(event: OneShotEvent) {
        // TODO("Not yet implemented")
    }

    override fun render(viewState: AboutScreenViewState) {
        when (viewState) {
            Initial -> {
                // TODO("Not yet implemented")
            }
            Loading -> {
                // TODO("Not yet implemented")
            }
            is AboutReady -> {
                // TODO("Not yet implemented")
            }
            NetworkError -> {
                // TODO("Not yet implemented")
            }
        }.exhaustive
    }
}