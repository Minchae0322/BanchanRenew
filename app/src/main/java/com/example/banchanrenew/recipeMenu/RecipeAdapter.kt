package com.example.banchanrenew.recipeMenu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.Ingredient.UpdateAdapterImpl
import com.example.banchanrenew.dao.RecipeDAO
import com.example.banchanrenew.relation.Recipe
import com.example.banchanrenew.relation.IngredientDC
import com.ramotion.foldingcell.FoldingCell

class RecipeAdapter(var list: List<Recipe>):
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>(), UpdateAdapterImpl {
    private var isFavorite = false
    private val dao: RecipeDAO = db.recipeDao()
    lateinit var context: Context
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
        val textViewContentNation: TextView = itemView.findViewById(R.id.tv_cell_content_nationIs)
        val textViewContentTime: TextView = itemView.findViewById(R.id.tv_cell_content_timeIs)
        val textViewContentKind: TextView = itemView.findViewById(R.id.tv_cell_content_kindIs)
        val textViewContentCalorie: TextView = itemView.findViewById(R.id.tv_cell_conent_calorieIs)
        val textViewContentSub: TextView = itemView.findViewById(R.id.tv_cell_content_sub)
        val textViewContentSeasoning: TextView = itemView.findViewById(R.id.tv_cell_content_seasoning)
        val textViewContentRecipeName: TextView = itemView.findViewById(R.id.tv_cell_content_recipeName)
        val textViewContentRecipeMenu: TextView = itemView.findViewById(R.id.tv_cell_content_recipeMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cell_recipe, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTitleName.text = list[position].recipeName
        holder.imageViewTitle.setImageResource(list[position].dishImage)
        holder.imageViewTitle.clipToOutline = true
        holder.textViewTitleExplain.text = list[position].explain
        if(list[position].bookMark == 1) {
            holder.imageViewStar.setImageResource(R.drawable.star)
            isFavorite = true
        } else {
            holder.imageViewStar.setImageResource(R.drawable.emptystar)
            isFavorite = false
        }
        holder.imageViewStar.setOnClickListener {
            if(isFavorite) {
                holder.imageViewStar.setImageResource(R.drawable.emptystar)
                dao.updateBookMarkOfRecipe(list[position].recipeID, 0)
                isFavorite = false
            } else {
                holder.imageViewStar.setImageResource(R.drawable.star)
                dao.updateBookMarkOfRecipe(list[position].recipeID, 1)
                isFavorite = true
            }
        }

        //content
        holder.foldingCell.setOnClickListener {
            holder.imageViewContent.setImageResource(list[position].dishImage)
            holder.imageViewContent.clipToOutline = true
            holder.textViewContentRecipeName.text = list[position].recipeName
            holder.textViewContentNation.text = list[position].nation
            holder.textViewContentTime.text = " " + list[position].cookingTime
            holder.textViewContentKind.text = list[position].type
            holder.textViewContentCalorie.text = list[position].calorie
            holder.textViewContentMain.text = parseIngredientDCToString(position, "주재료")
            holder.textViewContentSeasoning.text = parseIngredientDCToString(position, "부재료")
            holder.textViewContentSub.text = parseIngredientDCToString(position, "양념")
            holder.foldingCell.toggle(true)
            holder.textViewContentRecipeMenu.setOnClickListener {
                val dialog = RecipeDialog(context, dao.getRecipeInformation(list[position].recipeID), list[position].recipeName)
                dialog.showDialog()
            }
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }

    private fun parseIngredientDCToString(position: Int, type: String): String {
        val iDC: List<IngredientDC> = dao.getIngredientDCList(list[position].recipeID, type)
        var text = ""
        for(index in iDC) {
            text += index.ingredientDCName + ":  " + index.ingredientDCCapacity + ",    "
        }
        if(text.length >= 5) {
            return text.substring(0, text.length - 5)
        } else {
            return text
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun update() {
        notifyDataSetChanged()
    }

    override fun updateDataListFromDB(dataType: String) {
        list = RecipeListFactory().getRecipeList(dataType)
        update()
    }

    override fun updateRecipeDataList(dataList: MutableList<Recipe>) {
        list = dataList
        update()
    }
}