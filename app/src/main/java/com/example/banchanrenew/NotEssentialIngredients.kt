package com.example.banchanrenew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "notEssential",
    foreignKeys = [
        ForeignKey(entity = Dish::class, parentColumns = ["dishId"], childColumns = ["dishId"])
    ])
class NotEssentialIngredients(
    @PrimaryKey var dishId: Int,
    @ColumnInfo(name = "notEssential_name") var notEssential_name: String,
    @ColumnInfo(name = "notEssential_gram") var notEssential_gram: String
) {
}