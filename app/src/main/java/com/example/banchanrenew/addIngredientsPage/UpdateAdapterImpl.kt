package com.example.banchanrenew.addIngredientsPage

import com.example.banchanrenew.relation.Dish
import com.example.banchanrenew.relation.Ingredient


interface UpdateAdapterImpl  {
    fun update()
    fun updateDataListFromDB(dataType: String)
    fun updateIngredientDataList(dataList: MutableList<Ingredient>) {}
    fun updateRecipeDataList(dataList: MutableList<Dish>) {}
}