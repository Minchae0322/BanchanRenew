package com.example.banchanrenew.selectDish

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivitySelectedBinding
import com.example.banchanrenew.relation.Dish
import com.example.banchanrenew.relation.EssentialIngredients

class RecipeActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySelectedBinding
    private var spinnerNum: Int = 0
    private var dishList: List<Dish> = db.recipeDao().getDishList()
    private var dishListWithText: MutableList<Dish> = mutableListOf()
    private val recipeAdapter: RecipeAdapter = RecipeAdapter(dishList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initSpinner()

        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length == 0) {
                    recipeAdapter.list = dishList
                    recipeAdapter.notifyDataSetChanged()
                } else {
                    findDishListWithText(p0.toString())
                    recipeAdapter.list = dishListWithText
                    recipeAdapter.notifyDataSetChanged()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun initRecyclerView() {
        binding.recyclerViewSelected.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSelected.setHasFixedSize(true)
        binding.recyclerViewSelected.adapter = recipeAdapter
    }

    private fun findDishListWithText(charText: String) {
        dishListWithText.clear()
        when(spinnerNum) {
            0 -> {
                for(dish in dishList) {
                    if(dish.dishName.contains(charText)) {
                        dishListWithText.add(dish)
                    }
                }
            }
            1 -> {
                for(dish in dishList) {
                    var essentialList: MutableList<EssentialIngredients> = db.recipeDao().getEssentialListWhereDishID(dish.dishId)
                    for(essential in essentialList) {
                        if(essential.essential_name.contains(charText)) {
                            dishListWithText.add(dish)
                            break
                        }
                    }
                }
            }
        }
    }

    private fun initSpinner() {
        val spinnerList: List<String> = ArrayList(listOf("레시피로 찾기", "주재료로 찾기"))
        binding.spinnerSearch.adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item, spinnerList)
        binding.spinnerSearch.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerNum = p2
                when(p2) {
                    0 -> {
                        binding.editTextSearch.hint = "레시피이름을 입력하세요"
                    }
                    1 -> {
                        binding.editTextSearch.hint = "주재료를 입력하세요"
                    }
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?){
                binding.editTextSearch.hint = "레시피 이름을 입력하세요"
            }

        }
    }
}

