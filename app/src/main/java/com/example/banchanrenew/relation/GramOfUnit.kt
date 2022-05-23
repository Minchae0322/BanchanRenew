package com.example.banchanrenew.relation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GramOfUnit")
data class GramOfUnit (
    @PrimaryKey var unit: String,
    @ColumnInfo(name = "gramOfUnit") var gramOfUnit: Int) {

}