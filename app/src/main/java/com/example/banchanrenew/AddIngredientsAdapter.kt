package com.example.banchanrenew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

//재료 추기하기의 육류/가공품, 채소, 어류 리사이클러뷰 재료들이 리사이클러뷰의 뷰홀더에 들어감.
class AddIngredientsAdapter(private val list: ArrayList<Ingredient>):
    RecyclerView.Adapter<AddIngredientsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pagerImageView: ImageView = itemView.findViewById(R.id.pager_imageView)
        init {
            pagerImageView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewpager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pagerImageView.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}