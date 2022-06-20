package com.example.banchanrenew.recipeMenu

import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.relation.Recipe

class RecipeListFactory {

    fun getRecipeList(recipeType: String): List<Recipe> {
        when(recipeType) {
            "main" -> {
                return getDishList(db.recipeDao().getRecipeListIncludingMainIngredientsHave())
            }
            "all" -> {
                return db.recipeDao().getRecipeList()
            }
            "bookMark" -> {
                return db.recipeDao().getBookMarkedRecipeList(1)
            }
            else -> {
                return db.recipeDao().getRecipeList()
            }
        }
    }

    private fun getDishList(list: List<Int>): List<Recipe> {
        var dishList = mutableListOf<Recipe>()
        for(dishId in list) {
            dishList.add(db.recipeDao().getRecipeWithID(dishId))
        }

        return dishList
    }
}