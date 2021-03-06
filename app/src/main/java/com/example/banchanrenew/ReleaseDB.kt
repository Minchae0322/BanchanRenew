package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.dao.IngredientDAO
import com.example.banchanrenew.dao.RecipeDAO
import com.example.banchanrenew.relation.*

@Database(entities = [IngredientDC::class, RecipeDescription::class , Ingredient::class, GramOfUnit::class, Recipe::class, EssentialIngredients::class, NotEssentialIngredients:: class],  version = 1, exportSchema = true)
abstract class ReleaseDB: RoomDatabase() {
    abstract fun ingredientDAO() : IngredientDAO
    abstract fun recipeDao(): RecipeDAO
}