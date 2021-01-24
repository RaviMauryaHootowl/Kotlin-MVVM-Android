package com.raviowl.mvvmkotlin.ui.shoppinglist

import com.raviowl.mvvmkotlin.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}