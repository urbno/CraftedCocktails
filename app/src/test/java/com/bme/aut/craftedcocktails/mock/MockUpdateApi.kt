package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.network.api.UpdateApi

class MockUpdateApi: UpdateApi {

    override suspend fun updateCocktail(body: Cocktail?): Void {
        TODO("Not yet implemented")
    }
}