package com.bme.aut.craftedcocktails.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail")
data class CocktailEntity (
    @PrimaryKey(autoGenerate = true) var cocktailDBId: Long?,
    @ColumnInfo(name = "idDrink") var idDrink: String?,
    @ColumnInfo(name = "strDrink") var strDrink: String?,
    @ColumnInfo(name = "strCategory") var strCategory: String?,
    @ColumnInfo(name = "strAlcoholic") var strAlcoholic: String?,
    @ColumnInfo(name = "strGlass") var strGlass: String?,
    @ColumnInfo(name = "strInstructions") var strInstructions: String?,
    @ColumnInfo(name = "strDrinkThumb") var strDrinkThumb: String?,
    @ColumnInfo(name = "strIngredient1") var strIngredient1: String?,
    @ColumnInfo(name = "strIngredient2") var strIngredient2: String?,
    @ColumnInfo(name = "strIngredient3") var strIngredient3: String?,
    @ColumnInfo(name = "strIngredient4") var strIngredient4: String?,
    @ColumnInfo(name = "strIngredient5") var strIngredient5: String?,
    @ColumnInfo(name = "strMeasure1") var strMeasure1: String?,
    @ColumnInfo(name = "strMeasure2") var strMeasure2: String?,
    @ColumnInfo(name = "strMeasure3") var strMeasure3: String?,
    @ColumnInfo(name = "strMeasure4") var strMeasure4: String?,
    @ColumnInfo(name = "strMeasure5") var strMeasure5: String?,
)
