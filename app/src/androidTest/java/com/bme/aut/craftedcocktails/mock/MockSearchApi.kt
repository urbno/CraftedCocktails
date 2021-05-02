package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.SearchApi

class MockSearchApi: SearchApi {

    override suspend fun searchCocktailByName(s: String?): Response {
        TODO("Not yet implemented")
    }
}