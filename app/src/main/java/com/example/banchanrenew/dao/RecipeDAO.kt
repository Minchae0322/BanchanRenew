package com.example.banchanrenew.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.banchanrenew.relation.*

@Dao
interface RecipeDAO {

    @Insert
    fun insertRecipeDC(recipeDescription: RecipeDescription)

    @Insert
    fun insertRecipeDCList(recipeDescription: MutableList<RecipeDescription>)

    @Query("SELECT * FROM ingredientDC WHERE recipeID = :dishId AND ingredientDCType = :type")
    fun getIngredientDCList(dishId: Int, type: String): List<IngredientDC>

    @Query("SELECT * FROM Dish")
    fun getRecipeList(): List<Recipe>

    @Query("SELECT * FROM Dish WHERE recipeID = :dishId")
    fun getRecipeWithID(dishId: Int): Recipe

    @Query("SELECT * FROM essential WHERE recipeID = :recipeID")
    fun getMainIngredientListWithRecipeID(recipeID: Int): MutableList<EssentialIngredients>

    @Query("SELECT * FROM Dish WHERE bookMark = :oneIsTrueZeroFalse")
    fun getBookMarkedRecipeList(oneIsTrueZeroFalse: Int): List<Recipe>


    @Query(
        "SELECT e.recipeID  FROM " +
                "(SELECT essential.recipeID, Count(essential.recipeID) as count FROM essential Group by recipeID) as e " +
                "join (SELECT essential.recipeID, Count(essential.recipeID) as count FROM essential join ingredient on (essential_name = name) WHERE essential_gram <= remainGram And remainGram != 0 Group By essential.recipeID) as ei " +
                "on (e.recipeID = ei.recipeID) WHERE e.count = ei.count"
    )
    fun getRecipeListIncludingMainIngredientsHave(): List<Int> //레시피의 메인재료와 , 현재 보유하고 있는 메인재료를 비교하여 모두 보유시 레시피 IDList 반환
    
    @Query("SELECT * From Dish Where recipeID = :dishId")
    fun getRecipeListWithRecipeID(dishId: List<Int>): List<Recipe>

    @Query("UPDATE Dish SET bookMark = :oneIsTrueZeroFalse WHERE recipeID = :recipeID")
    fun updateBookMarkOfRecipe(recipeID: Int, oneIsTrueZeroFalse: Int)

    @Query("SELECT * From recipe WHERE recipeID = :recipeID")
    fun getRecipeInformation(recipeID: Int): MutableList<RecipeDescription>
}