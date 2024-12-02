package com.example.designtest

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.example.designtest.data.DummyData
import com.example.designtest.data.MusicItem

class SearchActivity : AppCompatActivity() {
    private lateinit var searchResultsRecyclerView: RecyclerView
    private lateinit var trendingRecyclerView: RecyclerView
    private lateinit var recentSearchesChipGroup: ChipGroup
    private lateinit var searchResultsTitle: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        
        // Initialize views
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView)
        trendingRecyclerView = findViewById(R.id.trendingRecyclerView)
        recentSearchesChipGroup = findViewById(R.id.recentSearchesChipGroup)
        searchResultsTitle = findViewById(R.id.searchResultsTitle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Search"

        // Setup recent searches
        setupRecentSearches()

        // Setup trending section
        setupTrendingSection()

        // Setup search functionality
        val searchView = findViewById<SearchView>(R.id.searchView)
        setupSearchView(searchView)
    }

    private fun setupRecentSearches() {
        recentSearchesChipGroup.removeAllViews()
        DummyData.recentSearches.forEach { searchTerm ->
            val chip = Chip(this).apply {
                text = searchTerm
                isCheckable = false
                setOnClickListener {
                    performSearch(searchTerm)
                }
            }
            recentSearchesChipGroup.addView(chip)
        }
    }

    private fun setupTrendingSection() {
        trendingRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        trendingRecyclerView.adapter = TrendingAdapter(DummyData.allSongs.take(8)) { item ->
            performSearch(item.title)
        }
    }

    private fun setupSearchView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { performSearch(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrBlank()) {
                    searchResultsTitle.visibility = View.GONE
                    searchResultsRecyclerView.visibility = View.GONE
                } else {
                    performSearch(newText)
                }
                return true
            }
        })
    }

    private fun performSearch(query: String) {
        // Show search results section
        searchResultsTitle.visibility = View.VISIBLE
        searchResultsRecyclerView.visibility = View.VISIBLE

        // Get search results from dummy data
        val searchResults = DummyData.searchSongs(query)

        // Update RecyclerView with search results
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(this)
        searchResultsRecyclerView.adapter = SearchResultsAdapter(searchResults) { item ->
            // Handle song click
            // For example: start playing the song
            Toast.makeText(this, "Playing: ${item.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
