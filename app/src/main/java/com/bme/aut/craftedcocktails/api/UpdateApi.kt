package com.bme.aut.craftedcocktails.api

import com.bme.aut.craftedcocktails.model.Cocktail
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT

interface UpdateApi {
    /**
     * Update an existing cocktail
     *
     * @param body Cocktail object that needs to be added to the database
     * @return Call<Void>
    </Void> */
    @PUT("modify.php")
    fun updateCocktail(
        @Body body: Cocktail?
    ): Call<Void?>?
}