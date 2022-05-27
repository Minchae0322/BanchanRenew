package com.example.banchanrenew.selectDish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.R
import com.example.banchanrenew.relation.Dish
import com.ramotion.foldingcell.FoldingCell

class RecipeAdapter(var list: List<Dish>): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
//TODO foldingCell Title 부분만 viewHolder 에  선언해놓은 상태이고 content 부분은 나중에 디자인 작업할때 해야한다.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val foldingCell: FoldingCell = itemView.findViewById(R.id.foldingCellTest)
         val textViewTitleName: TextView = itemView.findViewById(R.id.tv_foldingCellTitleName)
         val imageViewTitle: ImageView = itemView.findViewById(R.id.iv_foldingCellTitle)
         val textViewTitleExplain: TextView = itemView.findViewById(R.id.tv_foldingCellTitleExplain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selectedtest, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTitleName.text = list[position].dishName
        holder.imageViewTitle.setImageResource(list[position].dishImage)
        holder.textViewTitleExplain.text = list[position].explain
        holder.foldingCell.setOnClickListener {
            holder.foldingCell.toggle(true) }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}