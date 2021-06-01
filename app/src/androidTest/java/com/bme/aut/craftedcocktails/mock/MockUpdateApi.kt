package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.ApiResponse
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.network.api.UpdateApi
import kotlinx.coroutines.delay
import timber.log.Timber

class MockUpdateApi: UpdateApi {

    override suspend fun updateCocktail(body: Cocktail?): ApiResponse {
        delay(1000)
        return ApiResponse().apply {
            code = 200
            message = "Successfully updated cocktail!"
        }
    }
}