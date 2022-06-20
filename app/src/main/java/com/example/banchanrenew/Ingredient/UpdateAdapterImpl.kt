package com.example.banchanrenew.Ingredient

import com.example.banchanrenew.relation.Recipe
import com.example.banchanrenew.relation.Ingredient


interface UpdateAdapterImpl  {
    fun update()
    fun updateDataListFromDB(dataType: String)
    fun updateIngredientDataList(dataList: MutableList<Ingredient>) {}
    fun updateRecipeDataList(dataList: MutableList<Recipe>) {}
}