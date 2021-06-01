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
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_about.*
import java.lang.RuntimeException

class AboutScreenFragment : RainbowCakeFragment<AboutScreenViewState, AboutScreenViewModel>() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun getViewResource() = R.layout.fragment_about

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        viewModel.getAboutInfo()

        test_crash_button.setOnClickListener {
            throw RuntimeException("Test Crash")
        }
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
                firebaseAnalytics.logEvent("AboutReady") {
                    param("AboutReady", viewState.result)
                }
            }
        }.exhaustive
    }

    private fun initDetailView(authorName: String) {
        app_name.text = getString(R.string.app_name)
        author_name.text = authorName
        app_version.text = getString(R.string.app_version_number)
        learn_more_about.text = getString(R.string.repository_link)
        Glide.with(app_icon)
            .load(R.mipmap.ic_launcher)
            .into(app_icon)
    }
}