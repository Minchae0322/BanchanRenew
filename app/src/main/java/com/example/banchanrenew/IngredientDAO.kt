package com.example.banchanrenew

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.banchanrenew.relation.GramOfUnit
import com.example.banchanrenew.relation.Ingredient

@Dao
interface IngredientDAO {

    @Query("SELECT * FROM Ingredient")
    fun find(): List<Ingredient>

    //test
    @Insert fun insertIngredient(ingredient: Ingredient)

    @Insert fun insertGramOfUnit(gramOfUnit: GramOfUnit)

    @Query("SELECT id From Ingredient WHERE id = :id")
    fun find1Ingredient(id: Int): Int

    @Query("SELECT gramOfUnit From Ingredient natural join GramOfUnit WHERE id = :id")
    fun findJoinIngredient(id: Int): Int

    @Query("DELETE FROM Ingredient")
    fun delete()

    @Query("DELETE FROM GramOfUnit")
    fun delete2()
}