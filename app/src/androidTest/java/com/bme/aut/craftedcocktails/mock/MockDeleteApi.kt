package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.network.api.DeleteApi

class MockDeleteApi : DeleteApi {

    override suspend fun deleteCocktail(cocktailId: String?): Void {
        TODO("Not yet implemented")
    }
}