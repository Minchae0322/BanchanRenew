package com.example.banchanrenew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.accessibility.AccessibilityManagerCompat
import androidx.room.Database
import androidx.room.Room
import com.example.banchanrenew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {

        lateinit var db: TestDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            applicationContext, TestDatabase::class.java, "database1"
        ).allowMainThreadQueries().build()
    }


}