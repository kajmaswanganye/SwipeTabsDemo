package com.example.swipetabsdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var view_pager: ViewPager2
    private lateinit var tab_layout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view before accessing views
        setContentView(R.layout.activity_main)

        view_pager = findViewById(R.id.view_pager)
        tab_layout = findViewById(R.id.tab_layout)


        val fragments = listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        view_pager.adapter = ViewPagerFragmentAdapter(this, fragments)

        TabLayoutMediator(tab_layout, view_pager) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> tab.text = "Tab1Example"
                1 -> tab.text = "Tab2Example"
                2 -> tab.text = "Tab3Example"
                else -> tab.text = "Tab ${position + 1}"
            }
        }.attach()
    }
}

class ViewPagerFragmentAdapter(
    activity: AppCompatActivity,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}
