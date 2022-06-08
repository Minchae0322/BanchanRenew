package com.example.banchanrenew.relation

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "recipe", primaryKeys = ["dishId", "cookingNum"])
class Recipe (
    val dishId: Int,
    val cookingNum: Int,
    val cookingDC: String
    ) {
}