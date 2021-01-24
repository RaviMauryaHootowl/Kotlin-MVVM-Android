package com.raviowl.mvvmkotlin.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Shopping Item Entity for our database

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name= "item_name")
    var name: String,
    @ColumnInfo(name= "item_amount")
    var amount: Int
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null;

}