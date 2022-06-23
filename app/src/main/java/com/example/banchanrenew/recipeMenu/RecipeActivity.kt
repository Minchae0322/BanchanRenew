package com.example.banchanrenew.recipeMenu

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivityRecipeBinding
import com.example.banchanrenew.relation.Recipe
import com.example.banchanrenew.relation.EssentialIngredients

class RecipeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding
    private lateinit var recipeType: String
    private var spinnerNum: Int = 0
    private lateinit var recipeList: List<Recipe>
    private lateinit var recipeAdapter: RecipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        recipeType = intent.getStringExtra("recipeType").toString()
        recipeList = RecipeListFactory().getRecipeList(recipeType)
        setContentView(binding.root)
        initRecyclerView()
        initSpinner()



        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length == 0) {
                    recipeAdapter.updateDataListFromDB(recipeType)
                } else {
                    recipeAdapter.updateRecipeDataList(findDishListWithText(p0.toString()))
                }
                checkTextViewVisible()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun checkTextViewVisible() {
        binding.tvNoRecipe.isVisible = recipeAdapter.list.isEmpty()
    }

    private fun initRecyclerView() {
        binding.recyclerViewSelected.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSelected.setHasFixedSize(true)
        recipeAdapter = RecipeAdapter(recipeList)
        checkTextViewVisible()
        binding.recyclerViewSelected.adapter = recipeAdapter
    }

    private fun findDishListWithText(charText: String): MutableList<Recipe> {
        val dishListWithText: MutableList<Recipe> = mutableListOf()
        when(spinnerNum) {
            0 -> {
                for(dish in this.recipeList) {
                    if(dish.recipeName.contains(charText)) {
                        dishListWithText.add(dish)
                    }
                }
            }
            1 -> {
                for(dish in this.recipeList) {
                    var essentialList: MutableList<EssentialIngredients> = db.recipeDao().getMainIngredientListWithRecipeID(dish.recipeID)
                    for(essential in essentialList) {
                        if(essential.essential_name.contains(charText)) {
                            dishListWithText.add(dish)
                            break
                        }
                    }
                }
            }
        }
        return dishListWithText
    }

    private fun initSpinner() {
        val spinnerList: List<String> = ArrayList(listOf("레시피로 찾기", "주재료로 찾기"))
        binding.spinnerSearch.adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item ,spinnerList)
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

