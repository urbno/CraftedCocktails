package com.bme.aut.craftedcocktails.network.api

import retrofit2.http.DELETE
import retrofit2.http.Query

interface DeleteApi {
    /**
     * Deletes a cocktail
     *
     * @param cocktailId Cocktail id to delete
     * @return Call<Void>
    </Void> */
    @DELETE("delete.php")
    suspend fun deleteCocktail(
        @Query("cocktailId") cocktailId: String?
    ): Void
}