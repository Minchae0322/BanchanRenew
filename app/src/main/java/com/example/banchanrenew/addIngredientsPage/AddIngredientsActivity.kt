package com.example.banchanrenew.addIngredientsPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.banchanrenew.databinding.ActivityAddfridgeBinding
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class AddIngredientsActivity : FragmentActivity() {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private lateinit var binding: ActivityAddfridgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddfridgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPagerAdapter()
        initTabLayout()

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