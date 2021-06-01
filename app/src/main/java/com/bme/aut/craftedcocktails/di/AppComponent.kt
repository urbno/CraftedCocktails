package com.bme.aut.craftedcocktails.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import com.bme.aut.craftedcocktails.data.DiskModule
import com.bme.aut.craftedcocktails.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        DiskModule::class
    ]
)
interface AppComponent : RainbowCakeComponent