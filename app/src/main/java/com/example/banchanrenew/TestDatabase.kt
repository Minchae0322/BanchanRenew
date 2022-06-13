package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.relation.*
import com.example.banchanrenew.recipeMenu.RecipeDAO

@Database(entities = [IngredientDC::class, Recipe::class ,Ingredient::class, GramOfUnit::class, Dish::class, EssentialIngredients::class],  version = 8, exportSchema = true)
abstract class TestDatabase : RoomDatabase() {
    abstract fun testDao() : IngredientDAO
    abstract fun recipeDao(): RecipeDAO
}