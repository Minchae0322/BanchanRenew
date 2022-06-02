package com.example.banchanrenew.addIngredientsPage

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.R

//재료 추기하기의 육류/가공품, 채소, 어류 리사이클러뷰 재료들이 리사이클러뷰의 뷰홀더에 들어감.
class AddIngredientsAdapter(private var list: MutableList<Ingredient>):
    RecyclerView.Adapter<AddIngredientsAdapter.ViewHolder>() {
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

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageViewAddIngredients.setImageResource(list[position].image)
        holder.textViewAddIngredientsTitle.text = list[position].name
        holder.textViewAddIngredientsRemain.text = list[position].remainGram.toString() + "g"
        holder.itemView.setOnClickListener {
            val dialog = AddIngredientsDialog(context, list[position], this)
            dialog.showDialog()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList() {
        list = db.testDao().selectIngredientWhereDataType("meat")
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}