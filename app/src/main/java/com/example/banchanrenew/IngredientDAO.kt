package com.example.banchanrenew

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.banchanrenew.relation.*

@Dao
interface IngredientDAO {

    @Query("SELECT * FROM Ingredient")
    fun find(): List<Ingredient>

    //test
    @Insert fun insertIngredient(ingredient: Ingredient)

    @Insert fun insertIngredientList(list: List<Ingredient>)

    @Insert fun insertGramOfUnit(gramOfUnit: GramOfUnit)

    @Insert fun insertEssentialList(list: List<EssentialIngredients>)

    @Query("UPDATE Ingredient SET remainGram = :remain WHERE id = :id")
    fun updateTest(remain: Int, id: Int)

    @Query("SELECT unit From Ingredient WHERE id = :id")
    fun selectUnitFromIngredient(id: Int): String

    @Query("SELECT nation From Dish WHERE dishId = :id")
    fun eeeee(id: Int): String

    @Insert fun insertDishList(list: List<Dish>)

    @Query("SELECT * From Ingredient WHERE dataType = :dataType")
    fun selectIngredientWhereDataType(dataType: String): List<Ingredient>

    @Insert fun insertGramOfUnitList(list: List<GramOfUnit>)

    @Query("SELECT * From Dish")
    fun selectAllFromDish(): List<Dish>

    @Query("SELECT id From Ingredient WHERE id = :id")
    fun selectIdFromIngredientWhereId(id: Int): Int

    @Query("SELECT name From Ingredient WHERE id = :id")
    fun selectNameFromIngredientWhereId(id: Int): String


    @Query("DELETE FROM Ingredient")
    fun delete()

    @Query("DELETE FROM GramOfUnit")
    fun delete2()
}