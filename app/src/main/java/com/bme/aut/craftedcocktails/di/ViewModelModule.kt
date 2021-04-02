package com.bme.aut.craftedcocktails.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import com.bme.aut.craftedcocktails.ui.about.AboutScreenViewModel
import com.bme.aut.craftedcocktails.ui.details.DetailsScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.bme.aut.craftedcocktails.ui.main.MainScreenViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    abstract fun bindMainScreenViewModel(mainScreenViewModel: MainScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsScreenViewModel::class)
    abstract fun bindDetailsScreenViewModel(detailsScreenViewModel: DetailsScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutScreenViewModel::class)
    abstract fun bindAboutScreenViewModel(aboutScreenViewModel: AboutScreenViewModel): ViewModel
}