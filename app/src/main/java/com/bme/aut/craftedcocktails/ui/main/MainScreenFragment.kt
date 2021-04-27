package com.bme.aut.craftedcocktails.ui.main

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.method.KeyListener
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.navigator
import com.bme.aut.craftedcocktails.R
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.ui.about.AboutScreenFragment
import com.bme.aut.craftedcocktails.ui.details.DetailsScreenFragment
import com.bme.aut.craftedcocktails.ui.main.adapter.CocktailsAdapter
import com.example.awesomedialog.*
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber
import java.security.Key
import kotlin.random.Random

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    private var TAG = MainScreenFragment::class.java.simpleName
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

        drawer {
            hasStableIds = true
            savedInstance = savedInstanceState
            showOnFirstLaunch = false

            accountHeader {
                savedInstance = savedInstanceState
                translucentStatusBar = false
                profile("Urbán Norbert", "urban@norbert.hu")
            }

            sectionHeader("Menu") {
                divider = false
            }
            primaryItem("Cocktails") {
                iicon = GoogleMaterial.Icon.gmd_local_drink
                onClick(navigateToScreen("Cocktails"))
            }
            primaryItem("About") {
                iicon = GoogleMaterial.Icon.gmd_info
                onClick(navigateToScreen("About"))
            }

            sectionHeader("Options") {
                divider = true
            }
            primaryItem("Clear Database") {
                iicon = GoogleMaterial.Icon.gmd_storage
                onClick(deleteDatabase())
            }
        }

        cocktail_name_search_field.setOnEditorActionListener { v, keyCode, event ->
            Timber.d("$TAG keyCode: $keyCode event: $event")
            if (keyCode == EditorInfo.IME_ACTION_DONE) {
                val cocktailNameToSearch = cocktail_name_search_field.text.toString()
                if (cocktailNameToSearch.isNotEmpty()) {
                    Timber.d("$TAG cocktailNameToSearch: $cocktailNameToSearch")
                    viewModel.searchCocktailByName(cocktailNameToSearch)
                    cocktail_name_search_field.text?.clear()
                    return@setOnEditorActionListener true
                }
            }
            false
        }

        main_swipe.setOnRefreshListener {
            viewModel.loadCocktails()
        }

        cocktail_type_spinner.setItems("None", "Alcoholic", "Non Alcoholic")
        cocktail_type_spinner.setOnItemSelectedListener { view, position, id, item ->
            Timber.d("$TAG $item clicked")
            if (item != "None") {
                viewModel.searchByCocktailType(item as String)
            }
        }

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
                main_swipe.isRefreshing = false
                recycler_view.isVisible = true
            }
            NetworkError -> {
                progress_bar.isVisible = false
                recycler_view.isVisible = false
                showNetworkAlertDialog()
            }
            DatabaseError -> {
                progress_bar.isVisible = false
                recycler_view.isVisible = false
                showDatabaseAlertDialog()
            }
        }.exhaustive
    }

    override fun onEvent(event: OneShotEvent) {
    }

    private fun onCocktailItemClicked(cocktail: Cocktail) =
        navigator?.add(DetailsScreenFragment().applyArgs {
            putString(DetailsScreenFragment.COCKTAIL_ID, cocktail.idDrink)
        })

    private fun onCocktailItemLongClicked(cocktail: Cocktail): Boolean {
        showDeleteCocktailFromDB(cocktail.idDrink!!)
        return true
    }

    private fun navigateToScreen(screenName: String): (View?) -> Boolean = {
        when (screenName) {
            "Cocktails" -> {
                navigator?.add(MainScreenFragment())
            }
            "About" -> {
                navigator?.add(AboutScreenFragment())
            }
        }
        false
    }

    private fun deleteDatabase(): (View?) -> Boolean = {
        viewModel.deleteAllCocktails()
        viewModel.loadCocktails()
        false
    }

    private fun showNetworkAlertDialog() {
        AwesomeDialog.build(requireActivity())
            .title("Network Error", titleColor = Color.BLACK)
            .body("Something went wrong during network request", color = Color.BLACK)
            .icon(R.drawable.ic_error_symbol)
            .onPositive("Refresh") {
                Timber.d("$TAG network error on positive")
                viewModel.loadCocktails()
            }
    }

    private fun showDatabaseAlertDialog() {
        AwesomeDialog.build(requireActivity())
            .title("Database Error", titleColor = Color.BLACK)
            .body("Something went wrong during database request", color = Color.BLACK)
            .icon(R.drawable.ic_error_symbol)
            .onPositive("Refresh") {
                Timber.d("$TAG network error on positive")
                viewModel.loadCocktails()
            }
    }

    private fun showDeleteCocktailFromDB(cocktailId: String) {
        AwesomeDialog.build(requireActivity())
            .title("Delete", titleColor = Color.BLACK)
            .body("Do you really want to delete from database ?", color = Color.BLACK)
            .icon(R.drawable.ic_question_mark_symbol)
            .onPositive("Ok") {
                Timber.d("$TAG delete from database on positive")
                viewModel.deleteCocktailFromDatabase(cocktailId)
                viewModel.loadCocktails()
            }
            .onNegative("Cancel") {
                Timber.d("$TAG delete from database on negative")
            }
    }
}