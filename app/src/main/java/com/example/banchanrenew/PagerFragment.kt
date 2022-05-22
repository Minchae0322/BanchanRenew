package com.example.banchanrenew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.banchanrenew.databinding.ActivityMainBinding
import com.example.banchanrenew.databinding.FragmentPagerBinding

class PagerFragment(var list: ArrayList<Ingredient>): Fragment() {
    private lateinit var binding: FragmentPagerBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        return binding.root

    }


}