package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.ApiResponse
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.network.api.CreateApi
import kotlinx.coroutines.delay

class MockCreateApi : CreateApi {

    override suspend fun createNewCocktail(body: Cocktail?): ApiResponse {
        delay(1000)
        return ApiResponse().apply {
            message = "Successfully created new cocktail"
            code = 200
        }
    }
}