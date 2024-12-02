package com.example.designtest

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.adapters.PlaylistsAdapter
import com.example.designtest.data.DummyData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class PlaylistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlists)
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Playlists"

        setupRecyclerView()
        setupFab()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.playlistsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Show playlists in a grid

        // Create some sample playlists using DummyData
        val playlists = listOf(
            PlaylistsAdapter.Playlist(
                "Favorites",
                DummyData.allSongs.filter { it.isFavorite },
                R.drawable.ic_favorite
            ),
            PlaylistsAdapter.Playlist(
                "Recently Played",
                DummyData.allSongs.take(5),
                R.drawable.ic_history
            ),
            PlaylistsAdapter.Playlist(
                "Top Charts",
                DummyData.allSongs.sortedBy { it.title },
                R.drawable.ic_trending
            )
        )

        recyclerView.adapter = PlaylistsAdapter(playlists) { playlist ->
            val intent = Intent(this, PlaylistDetailActivity::class.java).apply {
                putExtra("PLAYLIST_NAME", playlist.name)
            }
            startActivity(intent)
        }
    }

    private fun setupFab() {
        findViewById<FloatingActionButton>(R.id.createPlaylistFab).setOnClickListener {
            Snackbar.make(it, "Create new playlist", Snackbar.LENGTH_SHORT).show()
            // TODO: Implement playlist creation
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
