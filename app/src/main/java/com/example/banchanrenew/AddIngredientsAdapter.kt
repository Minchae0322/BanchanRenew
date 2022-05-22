package com.example.banchanrenew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.databinding.ItemViewpagerBinding

class AddIngredientsAdapter(private val list: ArrayList<Ingredient>):
    RecyclerView.Adapter<AddIngredientsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pagerImageView: ImageView = itemView.findViewById(R.id.pager_imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_viewpager, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}