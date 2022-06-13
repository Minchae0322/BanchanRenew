package com.example.banchanrenew.recipeMenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.MainActivity
import com.example.banchanrenew.databinding.ActivityRecipeBinding


class RecipeWithInput: AppCompatActivity(){
    private lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        binding.editTextSearch

    }

    private fun initRecyclerView() {
        binding.recyclerViewSelected.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSelected.setHasFixedSize(true)
        binding.recyclerViewSelected.adapter = RecipeAdapter(MainActivity.db.recipeDao().getDishList())
    }
}