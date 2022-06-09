package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.selectDish.RecipeDAO
import com.example.banchanrenew.relation.*

@Database(entities = [IngredientDC::class, Recipe::class ,Ingredient::class, GramOfUnit::class, Dish::class, EssentialIngredients::class, NotEssentialIngredients:: class],  version = 6, exportSchema = true)
abstract class MainDatabase: RoomDatabase() {
    abstract fun databaseDao() : IngredientDAO
    abstract fun recipeDao(): RecipeDAO
}