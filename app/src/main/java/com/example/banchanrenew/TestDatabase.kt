package com.example.banchanrenew

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Ingredient::class, GramOfUnit::class],  version = 1, exportSchema = true)
abstract class TestDatabase : RoomDatabase() {
    abstract fun testDao() : IngredientDAO
}