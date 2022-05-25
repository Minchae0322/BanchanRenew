package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.relation.*

@Database(entities = [Ingredient::class, GramOfUnit::class, Dish::class, EssentialIngredients::class, NotEssentialIngredients:: class],  version = 1, exportSchema = true)
abstract class MainDatabase: RoomDatabase() {
    abstract fun databaseDao() : IngredientDAO
}