package com.example.banchanrenew.addIngredientsPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.R

//재료 추기하기의 육류/가공품, 채소, 어류 리사이클러뷰 재료들이 리사이클러뷰의 뷰홀더에 들어감.
class AddIngredientsRecyclerViewAdapter(private val list: List<Ingredient>):
    RecyclerView.Adapter<AddIngredientsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewAddIngredients: ImageView = itemView.findViewById(R.id.pager_imageView)
        val textViewAddIngredientsTitle: TextView = itemView.findViewById(R.id.textView_pager)
        val textViewAddIngredientsRemain: TextView = itemView.findViewById(R.id.textView_pager2)
        init {
            imageViewAddIngredients.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewpager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageViewAddIngredients.setImageResource(list[position].image)
        holder.textViewAddIngredientsTitle.text = list[position].name
        holder.textViewAddIngredientsRemain.text = list[position].remainGram.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}