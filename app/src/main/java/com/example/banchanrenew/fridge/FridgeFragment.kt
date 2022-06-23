package com.example.banchanrenew.fridge

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivityFridgeBinding
import com.example.banchanrenew.relation.Ingredient

class FridgeFragment: Fragment() {
    private lateinit var binding: ActivityFridgeBinding
    private val ingredientList: MutableList<Ingredient> = db.ingredientDAO().getIngredientListMoreThanZeroGram()
    private var ingredientListWithText: MutableList<Ingredient> = mutableListOf()
    private val fridgeAdapter: FridgeRecyclerViewAdapter = FridgeRecyclerViewAdapter(ingredientList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityFridgeBinding.inflate(layoutInflater, container, false)
        initRecyclerView()
        checkTextViewVisible()
        initEditText()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.rvFridge.layoutManager = GridLayoutManager(context,4)
        binding.rvFridge.setHasFixedSize(true)
        binding.rvFridge.adapter = fridgeAdapter
    }

    private fun checkTextViewVisible() {
        binding.tvNoRecipe.isVisible = fridgeAdapter.list.size == 0
    }

    override fun onResume() {
        super.onResume()
        Log.d("resume","resume")
    }



    private fun initEditText() {
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0?.length == 0) {
                    fridgeAdapter.updateDataListFromDB("dd")
                } else {
                    findIngredientListWithText(p0.toString())
                    fridgeAdapter.updateIngredientDataList(ingredientListWithText)
                }
                checkTextViewVisible()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun findIngredientListWithText(charText: String) {
        for(ingredient in ingredientList) {
            if(ingredient.name.contains(charText)) {
                ingredientListWithText.add(ingredient)
            }
        }
    }
}