package com.example.banchanrenew.fridge

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.addIngredientsPage.AddIngredientsActivity
import com.example.banchanrenew.databinding.ActivityFridgeBinding
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.selectDish.RecipeActivity

class FridgeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityFridgeBinding
    private var ingredientList: MutableList<Ingredient> = db.testDao().getIngredientMoreThanZeroGram()
    private var ingredientListWithText: MutableList<Ingredient> = mutableListOf()
    private val fridgeAdapter: FridgeAdapter = FridgeAdapter(ingredientList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFridgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initEditText()
        initTabLayout()

    }

    private fun initRecyclerView() {
        binding.rvFridge.layoutManager = GridLayoutManager(applicationContext,4)
        binding.rvFridge.setHasFixedSize(true)
        binding.rvFridge.adapter = fridgeAdapter
    }

    private fun initTabLayout() {
        binding.constraintLayoutRecipe.setOnClickListener {
            val nextIntent = Intent(this, RecipeActivity::class.java)
            nextIntent.flags = FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
            nextIntent.flags = FLAG_ACTIVITY_NO_ANIMATION
            startActivity(nextIntent)
        }

        binding.constraintLayoutAddIngredient.setOnClickListener {
            val nextIntent = Intent(this, AddIngredientsActivity::class.java)
            nextIntent.flags = FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
            nextIntent.flags = FLAG_ACTIVITY_NO_ANIMATION
            startActivity(nextIntent)
        }

        binding.constraintLayoutFridge.setOnClickListener {
            val nextIntent = Intent(this, FridgeActivity::class.java)
            nextIntent.flags = FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
            nextIntent.flags = FLAG_ACTIVITY_NO_ANIMATION
            startActivity(nextIntent)
        }
    }


    private fun initEditText() {
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length == 0) {
                    fridgeAdapter.list = ingredientList
                    fridgeAdapter.notifyDataSetChanged()
                } else {
                    findIngredientListWithText(p0.toString())
                    fridgeAdapter.list = ingredientListWithText
                    fridgeAdapter.notifyDataSetChanged()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun findIngredientListWithText(charText: String) {
        for(ingredient in ingredientList) {
            if(ingredient.name.contains(charText)) {
                ingredientListWithText.add(ingredient)
            }
        }
    }
}