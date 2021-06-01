package com.bme.aut.craftedcocktails.test

import com.bme.aut.craftedcocktails.mock.MockCreateApi
import com.bme.aut.craftedcocktails.mock.MockDeleteApi
import com.bme.aut.craftedcocktails.mock.MockUpdateApi
import com.bme.aut.craftedcocktails.model.Cocktail
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CrudTest {

    private lateinit var mockDeleteApi: MockDeleteApi
    private lateinit var mockUpdateApi: MockUpdateApi
    private lateinit var mockCreateApi: MockCreateApi

    @Before
    fun initializeNetworkDataSource() {
        mockCreateApi = MockCreateApi()
        mockDeleteApi = MockDeleteApi()
        mockUpdateApi = MockUpdateApi()
    }

    @Test
    fun deleteCocktailTest() {
        runBlocking {
            val response = mockDeleteApi.deleteCocktail("11007")
            assertEquals(200, response.code)
        }
    }

    @Test
    fun updateCocktailTest() {
        runBlocking {
            val response = mockUpdateApi.updateCocktail(Cocktail().apply {
                strDrink = "Test cocktail name"
            })
            assertEquals(200, response.code)
        }
    }

    @Test
    fun createCocktailTest() {
        runBlocking {
            val response = mockCreateApi.createNewCocktail(Cocktail().also { cocktail ->
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
            assertEquals(200, response.code)
        }
    }
}