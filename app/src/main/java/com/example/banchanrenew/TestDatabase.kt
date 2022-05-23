package com.example.banchanrenew

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banchanrenew.relation.GramOfUnit
import com.example.banchanrenew.relation.Ingredient

@Database(entities = [Ingredient::class, GramOfUnit::class],  version = 2, exportSchema = true)
abstract class TestDatabase : RoomDatabase() {
    abstract fun testDao() : IngredientDAO
}