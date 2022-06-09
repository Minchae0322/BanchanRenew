package com.example.banchanrenew.selectDish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.relation.Dish
import com.ramotion.foldingcell.FoldingCell

class RecipeAdapter(var list: List<Dish>): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    private var isFavorite = false
    private val dao: RecipeDAO = db.recipeDao()
//TODO foldingCell Title 부분만 viewHolder 에  선언해놓은 상태이고 content 부분은 나중에 디자인 작업할때 해야한다.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foldingCell: FoldingCell = itemView.findViewById(R.id.foldingCell)
        val textViewTitleName: TextView = itemView.findViewById(R.id.tv_cell_title_dishName)
        val imageViewTitle: ImageView = itemView.findViewById(R.id.iv_cell_title_dish)
        val textViewTitleExplain: TextView = itemView.findViewById(R.id.tv_cell_title_explain)
        val imageViewStar: ImageView = itemView.findViewById(R.id.iv_cell_title_star)

    //content
        val imageViewContent: ImageView = itemView.findViewById(R.id.iv_cell_content_dishImage)
        val textViewContentMain: TextView = itemView.findViewById(R.id.tv_cell_content_main)
        val textViewContentSub: TextView = itemView.findViewById(R.id.tv_cell_content_sub)
        val textViewContentSeasoning: TextView = itemView.findViewById(R.id.tv_cell_content_seasoning)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cell_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTitleName.text = list[position].dishName
        holder.imageViewTitle.setImageResource(list[position].dishImage)
        holder.imageViewTitle.clipToOutline = true
        holder.textViewTitleExplain.text = list[position].explain
        holder.foldingCell.setOnClickListener {
            holder.imageViewContent.setImageResource(list[position].dishImage)
            //TODO 주재료 부재료 양념 정보 담은 assets에 json넣고 그거 데이터베이스에 넣기 joson파싱해야됨
            // val iDC: List<IRDNTDescription> = dao.getIngredientDC(list[position].dishId,"주재료")
            // holder.textViewContentMain.text = iDC[0].ingredientDCName.toString()
            holder.foldingCell.toggle(true)
        }
        holder.imageViewStar.setOnClickListener {
            if(isFavorite) {
                holder.imageViewStar.setImageResource(R.drawable.emptystar)
                isFavorite = false
            } else {
                holder.imageViewStar.setImageResource(R.drawable.star)
                isFavorite = true
            }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}