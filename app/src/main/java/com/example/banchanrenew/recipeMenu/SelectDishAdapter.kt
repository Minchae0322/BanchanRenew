package com.example.banchanrenew.recipeMenu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.R

class SelectDishAdapter(val list: List<Int>): RecyclerView.Adapter<SelectDishAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_menuSelect)
        val imageView: ImageView = itemView.findViewById(R.id.imageView_selectdish)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selectdish, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(list[position])
        holder.textView.text = when(position) {
            0 -> {
                "모든 레시피"
            }
            1 -> {
                "냉장고 재료로 만들기"
            }
            2 -> {
                "즐겨찾기 레시피"
            }
            else -> {
                null
            }
        }
        holder.itemView.setOnClickListener {
            when(position) {
                0 -> {
                    val intent = Intent(holder.itemView.context, RecipeActivity::class.java)
                    startActivity(holder.itemView.context, intent, null)
                }

                1 -> {
                    val intent = Intent(holder.itemView.context, RecipeWithMainIngredientsActivity::class.java)
                    startActivity(holder.itemView.context, intent, null)
                }
                2 -> {
                    val intent = Intent(holder.itemView.context, RecipeWithBookMarkActivity::class.java)
                    startActivity(holder.itemView.context, intent, null)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}