package com.example.banchanrenew.relation

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "essential",
    foreignKeys = [
        ForeignKey(entity = Recipe::class, parentColumns = ["recipeID"], childColumns = ["recipeID"])
    ], primaryKeys = ["recipeID", "essential_name", "essential_gram"])
class EssentialIngredients(
    var essential_name: String,
    var essential_gram: String,
    var recipeID: Int
) {

}