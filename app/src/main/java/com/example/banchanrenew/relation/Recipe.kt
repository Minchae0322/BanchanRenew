package com.example.banchanrenew.relation

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "recipe", primaryKeys = ["recipeID", "cookingNum"])
class Recipe (
    val recipeID: Int,
    val cookingNum: Int,
    val cookingDC: String
    ) {
}