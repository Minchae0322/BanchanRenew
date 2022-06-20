package com.example.banchanrenew.recipeMenu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.R
import com.example.banchanrenew.relation.RecipeDescription

class RecipeDCDialogAdapter(val list: MutableList<RecipeDescription>): RecyclerView.Adapter<RecipeDCDialogAdapter.ViewHolder>() {
    private lateinit var context:Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewStep: TextView = itemView.findViewById(R.id.tv_dialog_recipe_step)
        val textViewDescription: TextView = itemView.findViewById(R.id.tv_dialog_recipe_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe_description, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewStep.text = "STEP  " + list[position].cookingNum
        holder.textViewDescription.text = list[position].cookingDC + "\n"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}