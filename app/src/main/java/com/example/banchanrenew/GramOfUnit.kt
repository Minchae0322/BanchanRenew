package com.example.banchanrenew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GramOfUnit")
class GramOfUnit (
    @PrimaryKey var unit: String,
    @ColumnInfo(name = "gramOfUnit") var gramOfUnit: Int) {

}