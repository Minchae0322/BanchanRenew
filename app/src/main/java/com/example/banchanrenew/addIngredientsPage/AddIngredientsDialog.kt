package com.example.banchanrenew.addIngredientsPage

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.DialogAddBinding
import com.example.banchanrenew.relation.Ingredient


class AddIngredientsDialog(val context: Context, var ingredient: Ingredient) {
    private val dialog = Dialog(context)
    private lateinit var binding: DialogAddBinding
    private var buttonNum: Int = 0
    private var editTextGram: Int = 0
    private var remain: Int = ingredient.remainGram

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
    }

    @SuppressLint("SetTextI18n")
    fun bindView() {
        binding.tvAddDialogName.text = ingredient.name
        binding.tvAddDialogRemain.text = "보유수량 :  " + ingredient.remainGram.toString() + "g"
        binding.tvAddDialogAfterChange.text = (remain + 100).toString() + "g"
        setMenuView()
        setEditTextView()
        setCheckView()
    }



    private fun setCheckView() {
        binding.tvAddDialogCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.tvAddDialogOk.setOnClickListener {
            when(buttonNum) {
                0 -> {
                    db.recipeDao().updateRemainOfIngredient(remain, ingredient.id)
                }
                1 -> {

                }
            }
        }
    }

    private fun setEditTextView() {
        binding.etAddDialogAmount.hint = "0"
        binding.etAddDialogAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {}

        })
        binding.tvMinus.setOnClickListener {
            if(editTextGram <= 100) {
                editTextGram = 0
            } else {
                editTextGram -= 100
            }
            updateView()
        }
        binding.tvPlus.setOnClickListener {
            when(buttonNum) {
                0 -> {
                    editTextGram += 100
                    updateView()
                }
                1 -> {
                    if(ingredient.remainGram - 100 <= editTextGram) {
                        editTextGram = ingredient.remainGram
                    } else {
                        editTextGram += 100
                        updateView()
                    }
                }
                2 -> {
                    editTextGram = ingredient.remainGram
                    updateView()
                }
            }

        }
    }

    private fun setMenuView() {
        binding.tvAddDialogPlus.setOnClickListener {
            menuClicked(0)
            updateView()
            binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(1, 100000))
        }
        binding.btAddDialogRemove.setOnClickListener {
            menuClicked(1)
            updateView()
            binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(0, ingredient.remainGram))
        }
        binding.tvAddDialogRemoveAll.setOnClickListener {
            menuClicked(2)
            updateView()
            binding.etAddDialogAmount.filters = arrayOf<InputFilter>(MinMaxFilter(0, 0))
        }
    }

    private fun menuClicked(count: Int) {
        menuUnClicked(count)
        when(count) {
            0 -> {
                binding.tvAddDialogPlus.setBackgroundResource(R.drawable.background_colorrounding)
                binding.tvAddDialogPlus.setTextColor(Color.WHITE)
                editTextGram = 0
                updateView()
            }
            1 -> {
                binding.btAddDialogRemove.setBackgroundResource(R.drawable.background_colorrounding)
                binding.btAddDialogRemove.setTextColor(Color.WHITE)
                editTextGram = 0
                updateView()
            }
            2 -> {
                binding.tvAddDialogRemoveAll.setBackgroundResource(R.drawable.background_colorrounding)
                binding.tvAddDialogRemoveAll.setTextColor(Color.WHITE)
                editTextGram = 0
                updateView()
            }
        }
        buttonNum =  count
    }

    private fun menuUnClicked(count: Int) {
        when(buttonNum) {
            0 -> {
                if(buttonNum != count) {
                    binding.tvAddDialogPlus.setBackgroundResource(R.drawable.background_rounding)
                    binding.tvAddDialogPlus.setTextColor(Color.parseColor("#919191"))
                }
            }
            1 -> {
                binding.btAddDialogRemove.setBackgroundResource(R.drawable.background_rounding)
                binding.btAddDialogRemove.setTextColor(Color.parseColor("#919191"))
            }
            2 -> {
                binding.tvAddDialogRemoveAll.setBackgroundResource(R.drawable.background_rounding)
                binding.tvAddDialogRemoveAll.setTextColor(Color.parseColor("#919191"))
            }
        }
    }

    private fun updateView() {
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
                remain = 0
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