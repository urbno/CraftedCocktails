package com.bme.aut.craftedcocktails.mock

import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.model.Drinks
import com.bme.aut.craftedcocktails.model.Response
import com.bme.aut.craftedcocktails.network.api.LookupApi
import kotlinx.coroutines.delay

class MockLookupApi : LookupApi {

    override suspend fun getCocktailById(i: String?): Response {
        delay(1000)
        return Response().also { response ->
            response.drinks = Drinks().also { drinks ->
                drinks.add(Cocktail().also { cocktail ->
                    cocktail.idDrink = "11007"
                    cocktail.strDrink = "Margarita"
                    cocktail.strCategory = "Ordinary Drink"
                    cocktail.strAlcoholic = "Alcoholic"
                    cocktail.strGlass = "Cocktail glass"
                    cocktail.strInstructions =
                        "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass."
                    cocktail.strDrinkThumb =
                        "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
                    cocktail.strIngredient1 = "Tequila"
                    cocktail.strIngredient2 = "Triple sec"
                    cocktail.strIngredient3 = "Lime juice"
                    cocktail.strIngredient4 = "Salt"
                    cocktail.strIngredient5 = null
                    cocktail.strMeasure1 = "1 1/2 oz "
                    cocktail.strMeasure2 = "1/2 oz "
                    cocktail.strMeasure3 = "1 oz "
                    cocktail.strMeasure4 = null
                    cocktail.strMeasure5 = null
                })
            }
        }
    }
}