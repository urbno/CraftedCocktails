package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.ApiResponse
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.network.api.CreateApi

class MockCreateApi : CreateApi {

    override suspend fun createNewCocktail(body: Cocktail?): ApiResponse {
        // TODO("Not yet implemented")
        return ApiResponse().apply {
            message = "Successfully created new cocktail"
            code = 200
        }
    }
}