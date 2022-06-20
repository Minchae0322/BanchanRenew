package com.example.banchanrenew.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.banchanrenew.relation.*

@Dao
interface RecipeDAO {
    @Query("UPDATE ingredient SET remainGram = :remain WHERE id = :id")
    fun updateRemainGramOfIngredient(remain: Int, id: Int)

    @Query("SELECT * FROM ingredientDC WHERE recipeID = :dishId AND ingredientDCType = :type")
    fun getIngredientDCList(dishId: Int, type: String): List<IngredientDC>

    @Query("SELECT * FROM Dish")
    fun getDishList(): List<Recipe>




    @Query("SELECT * FROM essential")
    fun getEssentialList(): List<EssentialIngredients>

    @Query("SELECT * FROM INGREDIENT WHERE remainGram > 0")
    fun getIngredientMoreThanZero(): List<Ingredient>

    @Query("SELECT * FROM Dish WHERE recipeID = :dishId")
    fun getRecipeWithID(dishId: Int): Recipe

    @Query("SELECT * FROM essential WHERE recipeID = :dishId")
    fun getEssentialListWhereDishID(dishId: Int): MutableList<EssentialIngredients>

    @Query("SELECT * FROM Dish WHERE bookMark = :oneIsTrueZeroFalse")
    fun getBookMarkedRecipeList(oneIsTrueZeroFalse: Int): List<Recipe>

    @Query(
        "SELECT e.recipeID  FROM " +
                "(SELECT essential.recipeID, Count(essential.recipeID) as count FROM essential Group by recipeID) as e " +
                "join (SELECT essential.recipeID, Count(essential.recipeID) as count FROM essential join ingredient on (essential_name = name) WHERE essential_gram <= remainGram And remainGram != 0 Group By essential.recipeID) as ei " +
                "on (e.recipeID = ei.recipeID) WHERE e.count = ei.count"
    )
    fun getRecipeListIncludingMainIngredientsHave(): List<Int>
    
    @Query("SELECT * From Dish Where recipeID = :dishId")
    fun getRecipeListWithRecipeID(dishId: List<Int>): List<Recipe>

    @Query("UPDATE Dish SET bookMark = :oneIsTrueZeroFalse WHERE recipeID = :recipeID")
    fun updateBookMarkOfRecipe(recipeID: Int, oneIsTrueZeroFalse: Int)

    @Query("SELECT * From recipe WHERE recipeID = :recipeID")
    fun getRecipeInformation(recipeID: Int): MutableList<RecipeDescription>
}