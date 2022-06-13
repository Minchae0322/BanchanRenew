package com.example.banchanrenew.recipeMenu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.R

class SelectDishAdapter(val list: List<Int>): RecyclerView.Adapter<SelectDishAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_menuSelect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selectdish, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = list[position].toString()
        holder.textView.setOnClickListener {
            when(position) {
                0 -> {
                    val intent = Intent(holder.itemView.context, RecipeWithMainIngredientsActivity::class.java)
                    startActivity(holder.itemView.context, intent, null)
                }

                1 -> {
                    val intent = Intent(holder.itemView.context, RecipeActivity::class.java)
                    startActivity(holder.itemView.context, intent, null)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}