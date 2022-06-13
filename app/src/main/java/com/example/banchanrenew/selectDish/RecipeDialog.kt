package com.example.banchanrenew.selectDish

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.DialogAddBinding
import com.example.banchanrenew.databinding.DialogRecipeBinding
import com.example.banchanrenew.relation.Recipe

class RecipeDialog(val context: Context, recipe: Recipe) {
    private val dialog = Dialog(context)
    private lateinit var binding: DialogRecipeBinding
    fun showDialog() {
        binding = DialogRecipeBinding.bind(LayoutInflater.from(context).inflate(R.layout.dialog_recipe, null))
        initDialog()

    }

    private fun initDialog() {
        dialog.setContentView(binding.root)
        dialog.show()
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }
}