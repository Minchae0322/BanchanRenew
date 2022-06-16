package com.example.banchanrenew.addIngredientsPage

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.DialogEasysettingBinding

class EasySettingDialog(val context: Context, private val addIngredientsAdapter: AddIngredientsAdapter, val dataType: String) {
    private val dialog = Dialog(context)
    private lateinit var binding: DialogEasysettingBinding
    private val adapter = EasySettingAdapter(db.testDao().selectIngredientWhereDataType(dataType))

    fun showDialog() {
        binding = DialogEasysettingBinding.bind(LayoutInflater.from(context).inflate(R.layout.dialog_easysetting, null))
        initDialog()
        bindViews()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.rvEasySetting.layoutManager = GridLayoutManager(this.context,4)
        binding.rvEasySetting.setHasFixedSize(true)
        binding.rvEasySetting.adapter = adapter
    }

    private fun initDialog() {
        dialog.setContentView(binding.root)
        dialog.show()
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    private fun easySettingToDB() {
        for(id in adapter.isCheckedList) {
            if(id != 0) {
                val remain = db.testDao().getRemainGramOfIngredient(id)
                db.testDao().updateRemainGramOfIngredient(remain + 500, id)
            }
        }
    }

    private fun bindViews() {
        binding.tvEasySettingOk.setOnClickListener {
            easySettingToDB()
            addIngredientsAdapter.updateList(dataType)
            dialog.dismiss()
        }
        binding.tvEasySettingCancel.setOnClickListener {
            dialog.dismiss()
        }
    }
}