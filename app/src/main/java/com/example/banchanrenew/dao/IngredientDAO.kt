package com.example.banchanrenew.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.banchanrenew.relation.*

@Dao
interface IngredientDAO {

    @Query("SELECT * FROM Ingredient")
    fun find(): List<Ingredient>

    @Insert fun insertRecipe(recipeDescription: RecipeDescription)

    @Insert fun insertRecipeList(recipeDescription: MutableList<RecipeDescription>)
    //test
    @Insert fun insertIngredient(ingredient: Ingredient)

    @Insert fun insertIngredientDC(ingredientDC: IngredientDC)

    @Insert fun insertIngredientDCList(ingredientDC: MutableList<IngredientDC>)

    @Insert fun insertIngredientList(list: List<Ingredient>)

    @Insert fun insertGramOfUnit(gramOfUnit: GramOfUnit)

    @Insert fun insertEssentialList(list: List<EssentialIngredients>)

    @Insert fun insertEssential(essentialIngredients: EssentialIngredients)

    @Query("UPDATE ingredient SET remainGram = :remain WHERE id = :id")
    fun updateRemainGramOfIngredient(remain: Int, id: Int)

    @Query("UPDATE ingredient SET remainGram = :remain WHERE id = :name")
    fun updateRemainGramOfIngredient(remain: Int, name: String)

    @Query("SELECT remainGram From Ingredient WHERE id = :id")
    fun getRemainGramOfIngredient(id: Int): Int

    @Query("SELECT unit From Ingredient WHERE id = :id")
    fun selectUnitFromIngredient(id: Int): String

    @Query("SELECT name From Ingredient WHERE name = :name")
    fun selectUnitFromIngredientName(name: String): String

    @Query("SELECT * FROM ingredientDC WHERE ingredientDCNum = :num")
    fun getIngredientDCFromDCNum(num: Int): IngredientDC

    @Query("SELECT nation From Dish WHERE recipeID = :id")
    fun eeeee(id: Int): String

    @Query("SELECT remainGram From ingredient WHERE name = :name")
    fun eee2(name: String): Int

    @Insert fun insertDishList(list: List<Recipe>)

    @Query("SELECT * From Ingredient WHERE dataType = :dataType")
    fun selectIngredientWhereDataType(dataType: String): MutableList<Ingredient>

    @Insert fun insertGramOfUnitList(list: List<GramOfUnit>)

    @Query("SELECT * FROM ingredient WHERE remainGram > 0")
    fun getIngredientMoreThanZeroGram(): MutableList<Ingredient>

    @Query("SELECT * From Dish")
    fun selectAllFromDish(): List<Recipe>

    @Query("SELECT id From Ingredient WHERE id = :id")
    fun selectIdFromIngredientWhereId(id: Int): Int

    @Query("SELECT name From Ingredient WHERE id = :id")
    fun selectNameFromIngredientWhereId(id: Int): String


    @Query("DELETE FROM Ingredient")
    fun delete()

    @Query("DELETE FROM GramOfUnit")
    fun delete2()

    @Query("DELETE FROM essential")
    fun delete3()

    @Query("DELETE FROM dish")
    fun delete4()

    @Query("DELETE FROM recipe")
    fun delete5()

    @Query("DELETE FROM ingredientDC")
    fun delete6()
}