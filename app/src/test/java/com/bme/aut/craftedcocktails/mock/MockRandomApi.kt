package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.RandomApi

class MockRandomApi: RandomApi {

    override suspend fun getRandomCocktail(): Response {
        TODO("Not yet implemented")
    }
}