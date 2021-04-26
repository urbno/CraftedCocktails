package com.bme.aut.craftedcocktails.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import com.bme.aut.craftedcocktails.R
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.ui.main.adapter.CocktailsAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    private lateinit var cocktailsAdapter: CocktailsAdapter

    override fun provideViewModel() = getViewModelFromFactory()

    override fun getViewResource() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cocktailsAdapter =
            CocktailsAdapter(requireContext(), ::onCocktailItemClicked, ::onCocktailItemLongClicked)
        recycler_view.adapter = cocktailsAdapter
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        viewModel.loadCocktails()
    }

    override fun render(viewState: MainScreenViewState) {
        when (viewState) {
            Initial -> {
            }
            Loading -> {
                progress_bar.isVisible = true
                recycler_view.isVisible = false
            }
            is DataReady -> {
                cocktailsAdapter.submitList(viewState.result)
                progress_bar.isVisible = false
                recycler_view.isVisible = true
            }
            NetworkError -> {
            }
        }.exhaustive
    }

    override fun onEvent(event: OneShotEvent) {
    }

    private fun onCocktailItemClicked(cocktail: Cocktail) {

    }

    private fun onCocktailItemLongClicked(cocktail: Cocktail): Boolean {
        return true
    }
}