package com.example.banchanrenew.recipeMenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.databinding.ActivitySelectRecipeMenuBinding

class SelectDishActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySelectRecipeMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectRecipeMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvSelectMenu.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvSelectMenu.setHasFixedSize(true)
        binding.rvSelectMenu.adapter = SelectDishAdapter(listOf(1,2))
    }
}