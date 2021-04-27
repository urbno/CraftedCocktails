package com.bme.aut.craftedcocktails.ui.details

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.bme.aut.craftedcocktails.R
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bumptech.glide.Glide
import com.example.awesomedialog.*
import kotlinx.android.synthetic.main.fragment_details.*
import timber.log.Timber

class DetailsScreenFragment :
    RainbowCakeFragment<DetailsScreenViewState, DetailsScreenViewModel>() {

    companion object {
        const val COCKTAIL_ID = "cocktailID"
    }

    private val TAG = DetailsScreenFragment::class.java.simpleName
    private lateinit var cocktailId: String

    override fun getViewResource() = R.layout.fragment_details

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cocktailId = requireArguments().getString(COCKTAIL_ID).toString()
        viewModel.getCocktailDetailsById(cocktailId)
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
                progress_bar.isVisible = true
                card_view.isVisible = false
            }
            is DetailsReady -> {
                Timber.d("$TAG details: ${viewState.result}")
                progress_bar.isVisible = false
                card_view.isVisible = true
                initDetailView(viewState.result)
            }
            DatabaseError -> {
                progress_bar.isVisible = false
                card_view.isVisible = false
                showDatabaseAlertDialog()
            }
        }
    }

    private fun initDetailView(cocktail: Cocktail) {
        Glide
            .with(cocktail_thumbnail)
            .load(cocktail.strDrinkThumb)
            .into(cocktail_thumbnail)

        cocktail_name.text = cocktail.strDrink
        cocktail_type.text = cocktail.strCategory
        cocktail_glass.text = cocktail.strGlass
        cocktail_description.text = cocktail.strInstructions
        if ((!cocktail.strIngredient1.isNullOrEmpty()) && (!cocktail.strMeasure1.isNullOrEmpty())) {
            cocktail_ingredients_1.isVisible = true
            cocktail_ingredients_qty_1.isVisible = true
            cocktail_ingredients_1.text = cocktail.strIngredient1
            cocktail_ingredients_qty_1.text = cocktail.strMeasure1
        }
        if ((!cocktail.strIngredient2.isNullOrEmpty()) && (!cocktail.strMeasure2.isNullOrEmpty())) {
            cocktail_ingredients_2.isVisible = true
            cocktail_ingredients_qty_2.isVisible = true
            cocktail_ingredients_2.text = cocktail.strIngredient2
            cocktail_ingredients_qty_2.text = cocktail.strMeasure2
        }
        if ((!cocktail.strIngredient3.isNullOrEmpty()) && (!cocktail.strMeasure3.isNullOrEmpty())) {
            cocktail_ingredients_3.isVisible = true
            cocktail_ingredients_qty_3.isVisible = true
            cocktail_ingredients_3.text = cocktail.strIngredient3
            cocktail_ingredients_qty_3.text = cocktail.strMeasure3
        }
        if ((!cocktail.strIngredient4.isNullOrEmpty()) && (!cocktail.strMeasure4.isNullOrEmpty())) {
            cocktail_ingredients_4.isVisible = true
            cocktail_ingredients_qty_4.isVisible = true
            cocktail_ingredients_4.text = cocktail.strIngredient4
            cocktail_ingredients_qty_4.text = cocktail.strMeasure4
        }
        if ((!cocktail.strIngredient5.isNullOrEmpty()) && (!cocktail.strMeasure5.isNullOrEmpty())) {
            cocktail_ingredients_5.isVisible = true
            cocktail_ingredients_qty_5.isVisible = true
            cocktail_ingredients_5.text = cocktail.strIngredient5
            cocktail_ingredients_qty_5.text = cocktail.strMeasure5
        }
    }

    private fun showDatabaseAlertDialog() {
        AwesomeDialog.build(requireActivity())
            .title("Database Error", titleColor = Color.BLACK)
            .body("Something went wrong during database request", color = Color.BLACK)
            .icon(R.drawable.ic_error_symbol)
            .onPositive("Refresh") {
                Timber.d("$TAG network error on positive")
                viewModel.getCocktailDetailsById(cocktailId)
            }
    }
}