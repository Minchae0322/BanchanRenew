package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.selectDish.RecipeDAO
import com.example.banchanrenew.relation.Dish
import com.example.banchanrenew.relation.EssentialIngredients
import com.example.banchanrenew.relation.GramOfUnit
import com.example.banchanrenew.relation.Ingredient

@Database(entities = [Ingredient::class, GramOfUnit::class, Dish::class, EssentialIngredients::class],  version = 4, exportSchema = true)
abstract class TestDatabase : RoomDatabase() {
    abstract fun testDao() : IngredientDAO
    abstract fun recipeDao(): RecipeDAO
}