package com.example.designtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.designtest.databinding.ActivityPlaylistDetailBinding
import com.google.android.material.appbar.AppBarLayout

class PlaylistDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaylistDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set up collapsing toolbar behavior
        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val scrollRange = appBarLayout.totalScrollRange
            val percentage = Math.abs(verticalOffset).toFloat() / scrollRange.toFloat()
            binding.playlistCover.alpha = 1f - percentage
        })

        // Set up RecyclerView
        binding.songsRecyclerView.layoutManager = LinearLayoutManager(this)
        // TODO: Set adapter for songs list

        // Set up click listeners
        binding.playButton.setOnClickListener {
            // TODO: Implement play functionality
        }

        binding.shuffleButton.setOnClickListener {
            // TODO: Implement shuffle functionality
        }

        binding.addSongsFab.setOnClickListener {
            // TODO: Implement add songs functionality
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
