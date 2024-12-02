package com.example.designtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.designtest.adapters.LibraryPagerAdapter
import com.example.designtest.fragments.SongsFragment
import com.example.designtest.utils.AnimationUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LibraryActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Set up activity transitions
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        // Initialize views
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        // Set up the toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Library"

        // Initialize fragments
        val fragments = listOf(
            SongsFragment.newInstance(),
            SongsFragment.newInstance(),  // Replace with AlbumsFragment when created
            SongsFragment.newInstance()   // Replace with ArtistsFragment when created
        )

        val adapter = LibraryPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        // Set up TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Songs"
                1 -> "Albums"
                2 -> "Artists"
                else -> ""
            }
        }.attach()

        // Animate the ViewPager when switching pages
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                (fragments[position] as? SongsFragment)?.refreshList()
            }
        })

        // Initial animation for the first fragment
        AnimationUtils.fadeIn(viewPager)
    }

    override fun finish() {
        super.finish()
        // Add exit transition
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}
