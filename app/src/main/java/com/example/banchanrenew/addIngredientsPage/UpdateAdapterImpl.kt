package com.example.banchanrenew.addIngredientsPage

import com.example.banchanrenew.relation.Ingredient


interface UpdateAdapterImpl  {
    fun update()
    fun updateDataListFromDB(dataType: String)
    fun updateDataList(dataList: MutableList<Ingredient>)
}