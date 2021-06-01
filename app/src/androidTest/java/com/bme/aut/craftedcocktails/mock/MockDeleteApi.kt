package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.ApiResponse
import com.bme.aut.craftedcocktails.network.api.DeleteApi
import kotlinx.coroutines.delay
import timber.log.Timber

class MockDeleteApi : DeleteApi {

    override suspend fun deleteCocktail(cocktailId: String?): ApiResponse {
        delay(1000)
        return ApiResponse().apply {
            code = 200
            message = "Successfully deleted cocktail with $cocktailId!"
        }
    }
}