package com.bme.aut.craftedcocktails.ui.about

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.transition.Visibility
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import com.bme.aut.craftedcocktails.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_about.*

class AboutScreenFragment : RainbowCakeFragment<AboutScreenViewState, AboutScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_about

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAboutInfo()
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
                progress_bar.isVisible = true
                card_view.isVisible = false
            }
            is AboutReady -> {
                progress_bar.isVisible = false
                card_view.isVisible = true
                initDetailView(viewState.result)
            }
            NetworkError -> {
                // TODO("Not yet implemented")
            }
        }.exhaustive
    }

    private fun initDetailView(authorName: String) {
        author_name.text = authorName
        app_version.text = "1.0.0"
        Glide.with(app_icon)
            .load(R.mipmap.ic_launcher)
            .into(app_icon)
    }
}