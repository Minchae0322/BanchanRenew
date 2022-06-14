package com.example.banchanrenew.addIngredientsPage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.banchanrenew.databinding.ActivityAddingredientBinding
import com.example.banchanrenew.fridge.FridgeFragment
import com.example.banchanrenew.recipeMenu.RecipeActivity
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class AddIngredientsActivity :Fragment() {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private lateinit var binding: ActivityAddingredientBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityAddingredientBinding.inflate(layoutInflater, container, false)
        initPagerAdapter()
        initTabLayout()
        return binding.root
    }

    private fun initPagerAdapter() {
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.viewPagerAddIngredients.adapter = pagerAdapter
    }

    private fun initTabLayout() {
        val tabTitleArray = arrayOf(
            "육류/가공품",
            "야채",
            "소스/향신료"
        )

        TabLayoutMediator(binding.tablayout, binding.viewPagerAddIngredients) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }



    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> {
                    MeatPagerFragment()
                }
                1 -> {
                    VegetablePagerFragment()
                }
                else -> {
                    SourcePagerFragment()
                }
            }

        }

    }
}