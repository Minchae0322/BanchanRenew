package com.example.banchanrenew.recipeMenu

import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.relation.Dish

class RecipeListFactory {

    fun getRecipeList(recipeType: String): List<Dish> {
        when(recipeType) {
            "main" -> {
                return getDishList(db.recipeDao().getDishListWithMainIngredients())
            }
            "all" -> {
                return db.recipeDao().getDishList()
            }
            "bookMark" -> {
                return db.recipeDao().getRecipeListWithBookMark(1)
            }
            else -> {
                return db.recipeDao().getDishList()
            }
        }
    }

    private fun getDishList(list: List<Int>): List<Dish> {
        var dishList = mutableListOf<Dish>()
        for(dishId in list) {
            dishList.add(db.recipeDao().getDishWhereId(dishId))
        }

        return dishList
    }
}