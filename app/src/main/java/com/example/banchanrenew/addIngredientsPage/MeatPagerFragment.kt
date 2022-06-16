package com.example.banchanrenew.addIngredientsPage

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.relation.Ingredient
import com.example.banchanrenew.databinding.FragmentPagerBinding

class MeatPagerFragment(): Fragment() {
    private lateinit var binding: FragmentPagerBinding
    private val dataList: MutableList<Ingredient> = db.testDao().selectIngredientWhereDataType("meat")
    private val adapter: AddIngredientsAdapter = AddIngredientsAdapter(dataList)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        initRecyclerView()
        initEditText()
        context
        Log.d("onCreateView","MeatPager")
        binding.layoutEasySetting.setOnClickListener {
            val easySettingDialog = EasySettingDialog(this.requireContext(), adapter, "meat")
            easySettingDialog.showDialog()
        }

        return binding.root
        //TODO easySetting 누르면 색 변하게

    }


    override fun onResume() {
        super.onResume()
        adapter.updateList("meat")
        Log.d("onResume","MeatPager")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","MeatPager")
    }

    private fun initEditText() {
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length == 0) {
                    adapter.list = dataList
                } else {
                    adapter.list = findListWithText(p0.toString())
                }
                adapter.notifyDataSetChanged()
            }
            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    private fun findListWithText(charText: String): MutableList<Ingredient> {
        val dataListWithText: MutableList<Ingredient> = mutableListOf()
        for(ingredient in dataList) {
            if(ingredient.name.contains(charText)) {
                dataListWithText.add(ingredient)
            }
        }
        return dataListWithText
    }

    private fun initRecyclerView() {
        binding.pagerRecyclerView.layoutManager = GridLayoutManager(this.context,4)
        binding.pagerRecyclerView.setHasFixedSize(true)
        binding.pagerRecyclerView.adapter = adapter

    }



}