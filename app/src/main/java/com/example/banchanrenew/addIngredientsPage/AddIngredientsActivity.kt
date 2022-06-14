package com.example.banchanrenew.addIngredientsPage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.banchanrenew.databinding.ActivityAddingredientBinding
import com.example.banchanrenew.fridge.FridgeActivity
import com.example.banchanrenew.recipeMenu.RecipeActivity
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class AddIngredientsActivity : FragmentActivity() {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private lateinit var binding: ActivityAddingredientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddingredientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPagerAdapter()
        initTabLayout()
        initStartActivityTabLayout()

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

    private fun initStartActivityTabLayout() {
        binding.constraintLayoutRecipe.setOnClickListener {
            val nextIntent = Intent(this, RecipeActivity::class.java)
            nextIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
            startActivity(nextIntent)
        }

        binding.constraintLayoutAddIngredient.setOnClickListener {
            val nextIntent = Intent(this, AddIngredientsActivity::class.java)
            nextIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET
            startActivity(nextIntent)
        }

        binding.constraintLayoutFridge.setOnClickListener {
            val nextIntent = Intent(this, FridgeActivity::class.java)
            nextIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET

            startActivity(nextIntent)
        }
    }



    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
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