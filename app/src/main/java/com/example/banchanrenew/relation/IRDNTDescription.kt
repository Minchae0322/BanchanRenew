package com.example.banchanrenew.relation

import android.view.inspector.IntFlagMapping
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredientDC")
class IRDNTDescription(
    val recipeId: Int,
    @PrimaryKey var ingredientDCNum: Int,
    val ingredientDCName: String,
    val ingredientDCCapacity: Int,
    val ingredientDCType: Int
)    {
}