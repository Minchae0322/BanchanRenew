package com.example.banchanrenew.addIngredientsPage

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.R
import com.example.banchanrenew.relation.Ingredient

class EasySettingAdapter(val list: List<Ingredient>) : RecyclerView.Adapter<EasySettingAdapter.ViewHolder>() {
    lateinit var context: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewAddIngredients: ImageView = itemView.findViewById(R.id.iv_fridge)
        val textViewAddIngredientsTitle: TextView = itemView.findViewById(R.id.tv_fridgeName)
        val textViewAddIngredientsRemain: TextView = itemView.findViewById(R.id.tv_fridgeAmount)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewpager, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageViewAddIngredients.setImageResource(list[position].image)
        holder.textViewAddIngredientsTitle.text = list[position].name
        holder.textViewAddIngredientsRemain.text = list[position].remainGram.toString() + "g"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}