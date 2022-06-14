package com.example.banchanrenew.recipeMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.FragmentSelectRecipeMenuBinding

class SelectDishFragment: Fragment() {
    private lateinit var binding: FragmentSelectRecipeMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectRecipeMenuBinding.inflate(layoutInflater, container, false)
        binding.rvSelectMenu.layoutManager = LinearLayoutManager(context)
        binding.rvSelectMenu.setHasFixedSize(true)
        binding.rvSelectMenu.adapter = SelectDishAdapter(listOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3))
        return binding.root
    }
}