package com.example.banchanrenew.relation

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "notEssential",
    foreignKeys = [
        ForeignKey(entity = Recipe::class, parentColumns = ["recipeID"], childColumns = ["recipeID"])
    ], primaryKeys = ["recipeID", "notEssential_name", "notEssential_gram"])
class NotEssentialIngredients(
    var recipeID: Int,
    var notEssential_name: String,
    var notEssential_gram: String
) {
}