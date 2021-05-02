package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.FilterApi

class MockFilterApi: FilterApi {

    override suspend fun searchCocktailByFilter(a: String?, i: String?): Response {
        TODO("Not yet implemented")
    }
}