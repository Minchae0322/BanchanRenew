package com.example.banchanrenew.relation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dish")
class Recipe(
    @ColumnInfo(name = "dishName") val recipeName: String,
    @PrimaryKey val recipeID: Int,
    @ColumnInfo(name = "explain") var explain: String?,
    @ColumnInfo(name = "nation") var nation: String?,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "cookingTime") var cookingTime: String?,
    @ColumnInfo(name = "calorie") var calorie: String?,
    @ColumnInfo(name = "dishImage") var dishImage: Int,
    )    {
    @ColumnInfo(name = "bookMark") var bookMark: Int = 0
}