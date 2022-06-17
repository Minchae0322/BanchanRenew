package com.example.banchanrenew.addIngredientsPage

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.MainActivity.Companion.DISPLAY_HEIGHT
import com.example.banchanrenew.MainActivity.Companion.DISPLAY_WITH
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.DialogAddBinding
import com.example.banchanrenew.relation.Ingredient


class IngredientModificationDialog(val context: Context, var ingredient: Ingredient, val adapter: UpdateAdapterImpl) {
    private val dialog = Dialog(context)
    private lateinit var binding: DialogAddBinding
    private var buttonNum: Int = 0
    private var editTextGram: Int = 100
    private var remain: Int = ingredient.remainGram + 100

    fun showDialog() {
        binding = DialogAddBinding.bind(LayoutInflater.from(context).inflate(R.layout.dialog_add, null))
        initDialog()
        bindView()

    }


    private fun initDialog() {
        dialog.setContentView(binding.root)
        dialog.show()
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    @SuppressLint("SetTextI18n")
    fun bindView() {
        binding.tvAddDialogName.text = ingredient.name
        binding.tvAddDialogRemain.text = "보유수량 :  " + ingredient.remainGram.toString() + "g"
        initMenuView()
        initEditTextView()
        initCheckView()
        updateAfterChangeTextView()
    }



    @SuppressLint("NotifyDataSetChanged")
    private fun initCheckView() {
        binding.tvAddDialogCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.tvAddDialogOk.setOnClickListener {
            updateRemain()
            db.recipeDao().updateRemainOfIngredient(remain,ingredient.id)
            adapter.updateDataListFromDB(ingredient.dataType)
            dialog.dismiss()
        }
    }

    private fun initEditTextView() {
        binding.etAddDialogAmount.hint = "0"
        updateEditTextView()
        binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(1, 100000))
        binding.etAddDialogAmount.setSelection( binding.etAddDialogAmount.length())
        binding.etAddDialogAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                editTextGram = if(p0.toString() == "") {
                    0
                } else {
                    p0.toString().toInt()
                }
                updateRemain()
                updateAfterChangeTextView()

            }
            override fun afterTextChanged(p0: Editable?) {}

        })
        binding.tvMinus.setOnClickListener {
            if(editTextGram <= 100) {
                editTextGram = 0
            } else {
                editTextGram -= 100
            }
            updateViews()
        }
        binding.tvPlus.setOnClickListener {
            when(buttonNum) {
                0 -> {
                    editTextGram += 100
                    updateViews()
                }
                1 -> {
                    if(ingredient.remainGram - 100 < editTextGram) {
                        editTextGram = ingredient.remainGram
                    } else {
                        editTextGram += 100
                        updateViews()
                    }
                }
                2 -> {
                    editTextGram = ingredient.remainGram
                    updateViews()
                }
            }

        }
    }

    private fun initMenuView() {
        binding.tvAddDialogPlus.setOnClickListener {
            binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(1, 100000))
            menuUnClicked(0)
            menuClicked(0)
            updateViews()
        }
        binding.tvAddDialogRemove.setOnClickListener {
            binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(0, ingredient.remainGram))
            menuUnClicked(1)
            menuClicked(1)
            updateViews()
        }
        binding.tvAddDialogRemoveAll.setOnClickListener {
            binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(0, ingredient.remainGram))
            menuUnClicked(2)
            menuClicked(2)
            updateViews()
        }
    }

    private fun menuClicked(count: Int) {
        when(count) {
            0 -> {
                binding.tvAddDialogPlus.setBackgroundResource(R.drawable.background_colorrounding)
                binding.tvAddDialogPlus.setTextColor(Color.WHITE)
                editTextGram = 100
            }
            1 -> {
                binding.tvAddDialogRemove.setBackgroundResource(R.drawable.background_colorrounding)
                binding.tvAddDialogRemove.setTextColor(Color.WHITE)
                editTextGram = 0
            }
            2 -> {
                binding.tvAddDialogRemoveAll.setBackgroundResource(R.drawable.background_colorrounding)
                binding.tvAddDialogRemoveAll.setTextColor(Color.WHITE)
                editTextGram = ingredient.remainGram
            }
        }
        buttonNum =  count
    }

    private fun menuUnClicked(count: Int) {
        if(buttonNum != count) {
            when (buttonNum) {
                0 -> {
                    binding.tvAddDialogPlus.setBackgroundResource(R.drawable.background_rounding)
                    binding.tvAddDialogPlus.setTextColor(Color.parseColor("#3E3E3E"))
                }
                1 -> {
                    binding.tvAddDialogRemove.setBackgroundResource(R.drawable.background_rounding)
                    binding.tvAddDialogRemove.setTextColor(Color.parseColor("#3E3E3E"))
                }
                2 -> {
                    binding.tvAddDialogRemoveAll.setBackgroundResource(R.drawable.background_rounding)
                    binding.tvAddDialogRemoveAll.setTextColor(Color.parseColor("#3E3E3E"))
                }
            }
        }
    }

    private fun updateViews() {
        updateEditTextView()
        updateRemain()
        updateAfterChangeTextView()
    }

    private fun updateEditTextView() {
        if(editTextGram == 0) {
            binding.etAddDialogAmount.setText("")
        } else {
            binding.etAddDialogAmount.setText(editTextGram.toString())
        }
    }

    private fun updateAfterChangeTextView() {
        binding.tvAddDialogAfterChange.text = remain.toString() + "g"
    }

    private fun updateRemain() {
        when(buttonNum) {
            0 -> {
                remain = ingredient.remainGram + editTextGram
            }
            1 -> {
                remain = ingredient.remainGram - editTextGram
            }
            2 -> {
                remain = ingredient.remainGram - editTextGram
            }
        }
    }


    inner class MinMaxFilter() : InputFilter {
        private var intMin: Int = 0
        private var intMax: Int = 0

        // Initialized
        constructor(minValue: Int, maxValue: Int) : this() {
            this.intMin = minValue
            this.intMax = maxValue
        }

        override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dStart: Int, dEnd: Int): CharSequence? {
            try {
                val input = Integer.parseInt(dest.toString() + source.toString())
                if (isInRange(intMin, intMax, input)) {
                    return null
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            return ""
        }

        // Check if input c is in between min a and max b and
        // returns corresponding boolean
        private fun isInRange(a: Int, b: Int, c: Int): Boolean {
            return if (b > a) c in a..b else c in b..a
        }
    }
}