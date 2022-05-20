package com.example.banchanrenew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "essential",
    foreignKeys = [
        ForeignKey(entity = Dish::class, parentColumns = ["dishId"], childColumns = ["dishId"])
    ])
class EssentialIngredients(
    @PrimaryKey var dishId: Int,
    @ColumnInfo(name = "essential_name") var essential_name: String,
    @ColumnInfo(name = "essential_gram") var essential_gram: String
) {

}