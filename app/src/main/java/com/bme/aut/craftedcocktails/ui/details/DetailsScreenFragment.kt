package com.bme.aut.craftedcocktails.ui.details

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.bme.aut.craftedcocktails.R

class DetailsScreenFragment :
    RainbowCakeFragment<DetailsScreenViewState, DetailsScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_details

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO("Not yet implemented")
    }

    override fun onEvent(event: OneShotEvent) {
        // TODO("Not yet implemented")
    }

    override fun render(viewState: DetailsScreenViewState) {
        when (viewState) {
            Initial -> {
                // TODO("Not yet implemented")
            }
            Loading -> {
                // TODO("Not yet implemented")
            }
            is DetailsReady -> {
                // TODO("Not yet implemented")
            }
            NetworkError -> {
                // TODO("Not yet implemented")
            }
        }
    }
}