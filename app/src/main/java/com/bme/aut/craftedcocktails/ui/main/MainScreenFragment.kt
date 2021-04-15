package com.bme.aut.craftedcocktails.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import com.bme.aut.craftedcocktails.R

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCocktails()
    }

    override fun render(viewState: MainScreenViewState) {
        when (viewState) {
            Initial -> {
            }
            Loading -> {
            }
            is DataReady -> {
                //Toast.makeText(context, viewState.result.toString(), Toast.LENGTH_LONG).show()
            }
            NetworkError -> {
            }
        }.exhaustive
    }

    override fun onEvent(event: OneShotEvent) {
    }
}