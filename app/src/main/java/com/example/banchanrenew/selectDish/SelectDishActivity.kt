package com.example.banchanrenew.selectDish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.databinding.ActivitySelectdishBinding

class SelectDishActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySelectdishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectdishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycelrViewSelectMenu.layoutManager = LinearLayoutManager(applicationContext)
        binding.recycelrViewSelectMenu.setHasFixedSize(true)
        binding.recycelrViewSelectMenu.adapter = SelectDishAdapter(listOf(1,2))
    }
}