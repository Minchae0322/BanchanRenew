package com.example.banchanrenew.recipeMenu

import androidx.room.Dao
import androidx.room.Query
import com.example.banchanrenew.relation.*

@Dao
interface RecipeDAO {
    @Query("UPDATE ingredient SET remainGram = :remain WHERE id = :id")
    fun updateRemainOfIngredient(remain: Int, id: Int)

    @Query("SELECT * FROM ingredientDC WHERE recipeID = :dishId AND ingredientDCType = :type")
    fun getIngredientDCList(dishId: Int, type: String): List<IngredientDC>

    @Query("SELECT * FROM Dish")
    fun getDishList(): List<Dish>




    @Query("SELECT * FROM essential")
    fun getEssentialList(): List<EssentialIngredients>

    @Query("SELECT * FROM INGREDIENT WHERE remainGram > 0")
    fun getIngredientMoreThanZero(): List<Ingredient>

    @Query("SELECT * FROM Dish WHERE recipeID = :dishId")
    fun getDishWhereId(dishId: Int): Dish

    @Query("SELECT * FROM essential WHERE recipeID = :dishId")
    fun getEssentialListWhereDishID(dishId: Int): MutableList<EssentialIngredients>

    @Query("SELECT * FROM Dish WHERE bookMark = :oneIsTrueZeroFalse")
    fun getRecipeWithBookMarkList(oneIsTrueZeroFalse: Int): List<Dish>

    @Query(
        "SELECT e.recipeID  FROM " +
                "(SELECT essential.recipeID, Count(essential.recipeID) as count FROM essential Group by recipeID) as e " +
                "join (SELECT essential.recipeID, Count(essential.recipeID) as count FROM essential join ingredient on (essential_name = name) WHERE essential_gram <= remainGram And remainGram != 0 Group By essential.recipeID) as ei " +
                "on (e.recipeID = ei.recipeID) WHERE e.count = ei.count"
    )
    fun getDishListWithMainIngredients(): List<Int>

    @Query("SELECT recipeID FROM essential join ingredient on (essential_name = name) WHERE essential_gram < remainGram Group By recipeID")
    fun getTest2(): List<Int>

    @Query("SELECT * From Dish Where recipeID = :dishId")
    fun getDishListWithDishId(dishId: List<Int>): List<Dish>

    @Query("UPDATE Dish SET bookMark = :oneIsTrueZeroFalse WHERE recipeID = :recipeID")
    fun updateBookMark(recipeID: Int, oneIsTrueZeroFalse: Int)

    @Query("SELECT * From recipe WHERE recipeID = :recipeID")
    fun getRecipeInformation(recipeID: Int): MutableList<Recipe>
}