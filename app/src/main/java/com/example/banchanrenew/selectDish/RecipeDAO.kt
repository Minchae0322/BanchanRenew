package com.example.banchanrenew.selectDish

import androidx.room.Dao
import androidx.room.Query
import com.example.banchanrenew.relation.Dish
import com.example.banchanrenew.relation.EssentialIngredients
import com.example.banchanrenew.relation.Ingredient

@Dao
interface RecipeDAO {
    @Query("UPDATE ingredient SET remainGram = :remain WHERE id = :id")
    fun updateRemainOfIngredient(remain: Int, id: Int)

    @Query("SELECT * FROM Dish")
    fun getDishList(): List<Dish>

    @Query("SELECT * FROM essential")
    fun getEssentialList(): List<EssentialIngredients>

    @Query("SELECT * FROM INGREDIENT WHERE remainGram > 0")
    fun getIngredientMoreThanZero(): List<Ingredient>

    @Query("SELECT * FROM Dish WHERE dishId = :dishId")
    fun getDishWhereId(dishId: Int): Dish

    @Query("SELECT * FROM essential WHERE dishID = :dishId")
    fun getEssentialListWhereDishID(dishId: Int): MutableList<EssentialIngredients>

    @Query("SELECT e.dishId  FROM " +
            "(SELECT essential.dishId, Count(essential.dishId) as count FROM essential Group by dishId) as e " +
            "join (SELECT essential.dishId, Count(essential.dishId) as count FROM essential join ingredient on (essential_name = name) WHERE essential_gram <= remainGram And remainGram != 0 Group By essential.dishId) as ei " +
            "on (e.dishId = ei.dishId) WHERE e.count = ei.count")
    fun getDishListWithMainIngredients(): List<Int>

    @Query("SELECT dishId FROM essential join ingredient on (essential_name = name) WHERE essential_gram < remainGram Group By dishId")
    fun getTest2(): List<Int>

    @Query("SELECT * From DIsh Where dishId = :dishId")
    fun getDishListWithDishId(dishId: List<Int>): List<Dish>
}