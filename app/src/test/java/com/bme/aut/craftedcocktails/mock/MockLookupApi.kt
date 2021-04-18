package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.LookupApi

class MockLookupApi: LookupApi {

    override suspend fun getCocktailById(i: String?): Response {
        TODO("Not yet implemented")
    }
}