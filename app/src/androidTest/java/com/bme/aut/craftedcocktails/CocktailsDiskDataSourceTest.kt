package com.bme.aut.craftedcocktails

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bme.aut.craftedcocktails.data.AppDatabase
import com.bme.aut.craftedcocktails.data.CocktailDao
import com.bme.aut.craftedcocktails.data.CocktailsDiskDataSource
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bme.aut.craftedcocktails.util.ItemConverter
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CocktailsDiskDataSourceTest {

    private lateinit var cocktailDao: CocktailDao
    private lateinit var database: AppDatabase
    private lateinit var cocktailsDiskDataSource: CocktailsDiskDataSource
    private val testCocktail = Cocktail().also {
        it.idDrink = "11007"
        it.strDrink = "Margarita"
        it.strCategory = "Ordinary Drink"
        it.strAlcoholic = "Alcoholic"
        it.strGlass = "Cocktail glass"
        it.strInstructions =
            "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass."
        it.strDrinkThumb =
            "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
        it.strIngredient1 = "Tequila"
        it.strIngredient2 = "Triple sec"
        it.strIngredient3 = "Lime juice"
        it.strIngredient4 = "Salt"
        it.strIngredient5 = null
        it.strMeasure1 = "1 1/2 oz "
        it.strMeasure2 = "1/2 oz "
        it.strMeasure3 = "1 oz "
        it.strMeasure4 = null
        it.strMeasure5 = null
    }

    @Before
    fun initializingDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        cocktailDao = database.cocktailDao()
        cocktailsDiskDataSource = CocktailsDiskDataSource(cocktailDao)
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun getSavedCocktails() {
        val cocktail =
            Cocktail().also {
                it.idDrink = "11007"
                it.strDrink = "Margarita"
                it.strCategory = "Ordinary Drink"
                it.strAlcoholic = "Alcoholic"
                it.strGlass = "Cocktail glass"
                it.strInstructions =
                    "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass."
                it.strDrinkThumb =
                    "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
                it.strIngredient1 = "Tequila"
                it.strIngredient2 = "Triple sec"
                it.strIngredient3 = "Lime juice"
                it.strIngredient4 = "Salt"
                it.strIngredient5 = null
                it.strMeasure1 = "1 1/2 oz "
                it.strMeasure2 = "1/2 oz "
                it.strMeasure3 = "1 oz "
                it.strMeasure4 = null
                it.strMeasure5 = null
            }

        runBlocking {
            cocktailsDiskDataSource.insertCocktails(ItemConverter.modelToEntity(cocktail))
            cocktailsDiskDataSource.insertCocktails(ItemConverter.modelToEntity(testCocktail))

            assertEquals(2, cocktailsDiskDataSource.getSavedCocktails().size)
        }
    }

    @Test
    fun getSpecificCocktail() {
        runBlocking {
            cocktailsDiskDataSource.insertCocktails(ItemConverter.modelToEntity(testCocktail))
            assertEquals(
                testCocktail.idDrink,
                cocktailsDiskDataSource.getSpecificCocktail(testCocktail.idDrink!!)[0].idDrink
            )
        }
    }

    @Test
    fun insertCocktails() {
        runBlocking {
            cocktailsDiskDataSource.insertCocktails(ItemConverter.modelToEntity(testCocktail))
            assertEquals(1, cocktailsDiskDataSource.getSavedCocktails().size)
        }
    }

    @Test
    fun deleteCocktail() {
        runBlocking {
            cocktailsDiskDataSource.insertCocktails(ItemConverter.modelToEntity(testCocktail))
            assertEquals(1, cocktailsDiskDataSource.getSavedCocktails().size)
            cocktailsDiskDataSource.deleteCocktail(testCocktail.idDrink!!)
            assertEquals(0, cocktailsDiskDataSource.getSavedCocktails().size)
        }
    }

    @Test
    fun deleteAllCocktails() {
        runBlocking {
            cocktailsDiskDataSource.insertCocktails(ItemConverter.modelToEntity(testCocktail))
            assertEquals(1, cocktailsDiskDataSource.getSavedCocktails().size)
            cocktailsDiskDataSource.deleteAllCocktails()
            assertEquals(0, cocktailsDiskDataSource.getSavedCocktails().size)
        }
    }
}