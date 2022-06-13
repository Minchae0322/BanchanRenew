package com.example.banchanrenew.recipeMenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivitySelectedBinding
import com.example.banchanrenew.relation.Dish

class RecipeWithMainIngredientsActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySelectedBinding
    private val recipeDao: RecipeDAO = db.recipeDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerViewSelected.setHasFixedSize(true)
        binding.recyclerViewSelected.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSelected.adapter = RecipeAdapter(getDishList(recipeDao.getDishListWithMainIngredients()))

    }

    private fun getDishList(list: List<Int>): List<Dish> {
        var dishList = mutableListOf<Dish>()
        for(dishId in list) {
            dishList.add(recipeDao.getDishWhereId(dishId))
        }

        return dishList
    }


}

