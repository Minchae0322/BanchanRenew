package com.example.banchanrenew.Ingredient

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
import com.example.banchanrenew.databinding.FragmentPagerBinding
import com.example.banchanrenew.relation.Ingredient

class PagerFragment(val dataType: String): Fragment() {
    private lateinit var binding: FragmentPagerBinding
    private val dataList: MutableList<Ingredient> = db.ingredientDAO().selectIngredientWhereDataType(dataType)
    private lateinit var adapter: IngredientRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        initRecyclerView()
        initEditText()
        context
        bindViews()
        return binding.root
    }

    private fun bindViews() {
        binding.layoutEasySetting.setOnClickListener {
            val easySettingDialog = EasySettingDialog(this.requireContext(), adapter, dataType)
            easySettingDialog.showDialog()
        }
        binding.textViewSearch.setOnClickListener {
            val easySettingDialog = EasySettingDialog(this.requireContext(), adapter, dataType)
            easySettingDialog.showDialog()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.updateDataListFromDB(dataType)
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
                    adapter.updateDataListFromDB(dataType)
                } else {
                    adapter.updateIngredientDataList(findListWithText(p0.toString()))
                }
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
        dataList.sortByDescending { it.remainGram }
        adapter = IngredientRecyclerViewAdapter(dataList)
        binding.pagerRecyclerView.adapter = adapter

    }
}