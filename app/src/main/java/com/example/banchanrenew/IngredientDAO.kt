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

    @Insert fun insertIngredientList(list: List<Ingredient>)

    @Insert fun insertGramOfUnit(gramOfUnit: GramOfUnit)

    @Query("SELECT unit From Ingredient WHERE id = :id")
    fun selectUnitFromIngredient(id: Int): String

    @Insert fun insertGramOfUnitList(list: List<GramOfUnit>)

    @Query("SELECT id From Ingredient WHERE id = :id")
    fun selectIdFromIngredientWhereId(id: Int): Int

    @Query("SELECT name From Ingredient WHERE id = :id")
    fun selectNameFromIngredientWhereId(id: Int): String


    @Query("DELETE FROM Ingredient")
    fun delete()

    @Query("DELETE FROM GramOfUnit")
    fun delete2()
}