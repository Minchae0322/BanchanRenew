package com.example.banchanrenew.relation

import android.view.inspector.IntFlagMapping
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredientDC")
class IngredientDC(
    val recipeId: Int,
    @PrimaryKey val ingredientDCNum: Int,
    val ingredientDCName: String,
    val ingredientDCCapacity: String,
    val ingredientDCType: String
)    {
}