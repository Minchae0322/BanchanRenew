package com.example.banchanrenew.recipeMenu

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.DialogRecipeBinding
import com.example.banchanrenew.relation.RecipeDescription

class RecipeDCDialog(val context: Context, private val recipeDescriptionList: MutableList<RecipeDescription>, private val recipeName: String) {
    private val dialog = Dialog(context)
    private lateinit var binding: DialogRecipeBinding

    @SuppressLint("SetTextI18n")
    fun showDialog() {
        binding = DialogRecipeBinding.bind(LayoutInflater.from(context).inflate(R.layout.dialog_recipe, null))
        initDialog()
        initRecyclerView()
        binding.tvDialogRecipeTitle.text = recipeName + "의 레시피 정보"
        binding.tvDialogRecipeExitButton.setOnClickListener {
            dialog.dismiss()
        }

    }

    private fun initDialog() {
        dialog.setContentView(binding.root)
        dialog.show()
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun initRecyclerView() {
        binding.rvRecipe.layoutManager = LinearLayoutManager(context)
        binding.rvRecipe.setHasFixedSize(true)
        recipeDescriptionList.sortedBy { it.cookingNum }
        binding.rvRecipe.adapter = RecipeDCDialogAdapter(recipeDescriptionList)
    }
}