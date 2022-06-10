package com.example.banchanrenew.relation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.banchanrenew.relation.Dish

@Entity(tableName = "notEssential",
    foreignKeys = [
        ForeignKey(entity = Dish::class, parentColumns = ["recipeID"], childColumns = ["recipeID"])
    ], primaryKeys = ["recipeID", "notEssential_name", "notEssential_gram"])
class NotEssentialIngredients(
    var recipeID: Int,
    var notEssential_name: String,
    var notEssential_gram: String
) {
}