package com.example.banchanrenew.relation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.banchanrenew.relation.Dish

@Entity(tableName = "essential",
    foreignKeys = [
        ForeignKey(entity = Dish::class, parentColumns = ["dishId"], childColumns = ["dishId"])
    ], primaryKeys = ["dishId", "essential_name", "essential_gram"])
class EssentialIngredients(
    var essential_name: String,
    var essential_gram: String,
    var dishId: Int
) {

}