package com.example.banchanrenew.chooseDish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivitySelectdishBinding
import com.example.banchanrenew.databinding.ActivitySelectedBinding

class RecipeActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySelectedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewSelected.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewSelected.setHasFixedSize(true)
        binding.recyclerViewSelected.adapter = RecipeAdapter(db.testDao().selectAllFromDish())

    }
}