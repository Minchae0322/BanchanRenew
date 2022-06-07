package com.example.banchanrenew.relation

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "recipe", foreignKeys = [
    ForeignKey(entity = Dish::class, parentColumns = ["dishId"], childColumns = ["dishId"])
], primaryKeys = ["dishId", "cookingNum"])
class Recipe (
    val dishId: Int,
    val cookingNum: Int,
    val cookingDC: String
    ) {
}