package com.raviowl.mvvmkotlin.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raviowl.mvvmkotlin.R
import com.raviowl.mvvmkotlin.data.db.entities.ShoppingItem
import com.raviowl.mvvmkotlin.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false);
        return ShoppingViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position];

        holder.itemView.itemNameTxt.text = curShoppingItem.name
        holder.itemView.itemAmountTxt.text = "Rs. ${curShoppingItem.amount}"

        holder.itemView.delItemBtn.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.addAmtBtn.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.subAmtBtn.setOnClickListener {
            if(curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }

    }

}