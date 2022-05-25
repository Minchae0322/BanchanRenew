package com.example.banchanrenew.chooseDish

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.banchanrenew.databinding.ActivitySelectdishBinding

class SelectDishActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySelectdishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectdishBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}