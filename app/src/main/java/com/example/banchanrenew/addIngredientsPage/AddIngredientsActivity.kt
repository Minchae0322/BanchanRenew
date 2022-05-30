package com.example.banchanrenew.addIngredientsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.banchanrenew.MainActivity
import com.example.banchanrenew.MainActivity.Companion.db
import com.example.banchanrenew.R
import com.example.banchanrenew.databinding.ActivityAddfridgeBinding
import com.google.android.material.tabs.TabLayout

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
        //https://korean-otter.tistory.com/entry/android-kotlin-TabLayout%EA%B3%BC-ViewPager%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
        binding.tablayout.addTab(binding.tablayout.newTab().setCustomView(createCustomView("육류/가공품")))
        binding.tablayout.addTab(binding.tablayout.newTab().setCustomView(createCustomView("채소")))
        binding.tablayout.addTab(binding.tablayout.newTab().setCustomView(createCustomView("소스/향신료")))
        binding.tablayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun createCustomView(text: String): View? {
        val inflater = LayoutInflater.from(applicationContext)
        val view: View = inflater.inflate(R.layout.tab_custom, null)
        val textView = view.findViewById<View>(R.id.tv_tab) as TextView
        textView.text = text
        return view
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
                    MeatPagerFragment(MainActivity.db.testDao().selectIngredientWhereDataType("meat"))
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