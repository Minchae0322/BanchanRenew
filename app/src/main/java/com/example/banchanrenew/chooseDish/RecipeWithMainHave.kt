package com.example.banchanrenew.chooseDish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banchanrenew.databinding.ActivitySelectedBinding

class RecipeWithMainHave: AppCompatActivity() {
    private lateinit var binding: ActivitySelectedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun findRecipeWithMainHave() {

    }
}