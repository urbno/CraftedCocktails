package com.bme.aut.craftedcocktails

import com.bme.aut.craftedcocktails.mock.MockNetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MockNetworkModule::class,
    ]
)
interface TestComponent