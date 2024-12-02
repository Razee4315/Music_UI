package com.example.designtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up bottom navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Already on home
                    true
                }
                R.id.navigation_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }
                R.id.navigation_library -> {
                    startActivity(Intent(this, LibraryActivity::class.java))
                    true
                }
                R.id.navigation_playlists -> {
                    startActivity(Intent(this, PlaylistsActivity::class.java))
                    true
                }
                R.id.navigation_favorites -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Set up mini player click listener
        val miniPlayerCard = findViewById<MaterialCardView>(R.id.miniPlayerCard)
        miniPlayerCard.setOnClickListener {
            startActivity(Intent(this, NowPlayingActivity::class.java))
        }

        // Set up quick action cards click listeners
        val historyCard = findViewById<MaterialCardView>(R.id.historyCard)
        val lastAddedCard = findViewById<MaterialCardView>(R.id.lastAddedCard)
        val mostPlayedCard = findViewById<MaterialCardView>(R.id.mostPlayedCard)
        val shuffleCard = findViewById<MaterialCardView>(R.id.shuffleCard)

        historyCard.setOnClickListener {
            // Handle history card click
        }

        lastAddedCard.setOnClickListener {
            // Handle last added card click
        }

        mostPlayedCard.setOnClickListener {
            // Handle most played card click
        }

        shuffleCard.setOnClickListener {
            // Handle shuffle card click
        }
    }
}
