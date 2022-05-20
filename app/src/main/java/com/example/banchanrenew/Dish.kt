package com.example.banchanrenew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dish")
class Dish(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "dishId") val dishId: Int,
    @ColumnInfo(name = "explain") var explain: String?,
    @ColumnInfo(name = "nation") var nation: String?,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "cookingTime") var cookingTime: String?,
    @ColumnInfo(name = "calorie") var calorie: String?,
    @ColumnInfo(name = "dishImage") var dishImage: Int,
    )    {
}