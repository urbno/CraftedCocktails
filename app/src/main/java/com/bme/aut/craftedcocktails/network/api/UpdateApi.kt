package com.bme.aut.craftedcocktails.network.api

import com.bme.aut.craftedcocktails.model.Cocktail
import retrofit2.http.Body
import retrofit2.http.PATCH

interface UpdateApi {
    /**
     * Update an existing cocktail
     *
     * @param body Represent the parts of the cocktail that needs to be updated in the database
     * @return Call<Void>
    </Void> */
    @PATCH("modify.php")
    suspend fun updateCocktail(
        @Body body: Cocktail?
    ): Void
}