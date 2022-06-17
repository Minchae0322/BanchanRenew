package com.example.banchanrenew.fridge

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.MainActivity
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.addIngredientsPage.IngredientModificationDialog
import com.example.banchanrenew.addIngredientsPage.UpdateAdapterImpl
import com.example.banchanrenew.relation.Ingredient

class FridgeAdapter(var list: MutableList<Ingredient>):
    RecyclerView.Adapter<FridgeAdapter.ViewHolder>(), UpdateAdapterImpl {
    private lateinit var context: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_fridge)
        val textViewName: TextView = itemView.findViewById(R.id.tv_fridgeName)
        val textViewAmount: TextView = itemView.findViewById(R.id.tv_fridgeAmount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fridge, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(list[position].image)
        holder.textViewName.text = list[position].name
        holder.textViewAmount.text = list[position].remainGram.toString() + "g"
        holder.itemView.setOnClickListener {
            //TODO
        val dialog = IngredientModificationDialog(context, list[position], this)
            dialog.showDialog()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun update(dataType: String) {
        list = db.testDao().getIngredientMoreThanZeroGram()
        notifyDataSetChanged()
    }
}