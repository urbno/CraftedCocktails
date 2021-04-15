package com.bme.aut.craftedcocktails.util

import com.bme.aut.craftedcocktails.data.CocktailEntity
import com.bme.aut.craftedcocktails.model.Cocktail

object ItemConverter {

    fun modelToEntity(cocktailModel: Cocktail) =
        CocktailEntity(
            cocktailDBId = null,
            idDrink = cocktailModel.idDrink,
            strDrink = cocktailModel.strDrink,
            strCategory = cocktailModel.strCategory,
            strAlcoholic = cocktailModel.strAlcoholic,
            strGlass = cocktailModel.strGlass,
            strInstructions = cocktailModel.strInstructions,
            strDrinkThumb = cocktailModel.strDrinkThumb,
            strIngredient1 = cocktailModel.strIngredient1,
            strIngredient2 = cocktailModel.strIngredient2,
            strIngredient3 = cocktailModel.strIngredient3,
            strIngredient4 = cocktailModel.strIngredient4,
            strIngredient5 = cocktailModel.strIngredient5,
            strMeasure1 = cocktailModel.strMeasure1,
            strMeasure2 = cocktailModel.strMeasure2,
            strMeasure3 = cocktailModel.strMeasure3,
            strMeasure4 = cocktailModel.strMeasure4,
            strMeasure5 = cocktailModel.strMeasure5
        )

    fun entityToModel(cocktailEntity: CocktailEntity) = Cocktail().also {
        it.idDrink = cocktailEntity.idDrink
        it.strDrink = cocktailEntity.strDrink
        it.strCategory = cocktailEntity.strCategory
        it.strAlcoholic = cocktailEntity.strAlcoholic
        it.strGlass = cocktailEntity.strGlass
        it.strInstructions = cocktailEntity.strInstructions
        it.strDrinkThumb = cocktailEntity.strDrinkThumb
        it.strIngredient1 = cocktailEntity.strIngredient1
        it.strIngredient2 = cocktailEntity.strIngredient2
        it.strIngredient3 = cocktailEntity.strIngredient3
        it.strIngredient4 = cocktailEntity.strIngredient4
        it.strIngredient5 = cocktailEntity.strIngredient5
        it.strMeasure1 = cocktailEntity.strMeasure1
        it.strMeasure2 = cocktailEntity.strMeasure2
        it.strMeasure3 = cocktailEntity.strMeasure3
        it.strMeasure4 = cocktailEntity.strMeasure4
        it.strMeasure5 = cocktailEntity.strMeasure5
    }
}