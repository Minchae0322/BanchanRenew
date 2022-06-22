package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.dao.IngredientDAO
import com.example.banchanrenew.relation.*
import com.example.banchanrenew.dao.RecipeDAO

@Database(entities = [IngredientDC::class, RecipeDescription::class ,Ingredient::class, GramOfUnit::class, Recipe::class, EssentialIngredients::class],  version = 9, exportSchema = true)
abstract class TestDatabase : RoomDatabase() {
    abstract fun ingredientDAO() : IngredientDAO
    abstract fun recipeDao(): RecipeDAO
}