package com.example.banchanrenew.addIngredientsPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.databinding.ActivityAddfridgeBinding

/**
 * The number of pages (wizard steps) to show in this demo.
 */
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

        // Instantiate a ViewPager2 and a PagerAdapter.

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        binding.viewPagerAddIngredients.adapter = pagerAdapter
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
                    MeatPagerFragment(db.testDao().find())
                }
                1 -> {
                    VegetablePagerFragment(db.testDao().find())
                }
                else -> {
                    FishPagerFragment(db.testDao().find())
                }
            }

        }

    }
}