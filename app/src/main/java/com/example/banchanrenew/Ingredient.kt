package com.example.banchanrenew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.lang.annotation.Inherited


@Entity(tableName = "Ingredient",
    foreignKeys = [
        ForeignKey(entity = GramOfUnit::class, parentColumns = ["unit"], childColumns = ["unit"])
    ])
class Ingredient (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "unit") var unit: String,
    @ColumnInfo(name = "image") var image: Int,
    @ColumnInfo(name = "dataType") var dataType: String)