package com.example.banchanrenew.addIngredientsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.FragmentPagerBinding

class FishPagerFragment(var list: List<Ingredient>): Fragment() {
    private lateinit var binding: FragmentPagerBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.pagerRecyclerView.adapter = AddIngredientsRecyclerViewAdapter(db.testDao().find())
        binding.pagerRecyclerView.layoutManager = GridLayoutManager(this.context,3)
        binding.pagerRecyclerView.setHasFixedSize(true)
    }


}