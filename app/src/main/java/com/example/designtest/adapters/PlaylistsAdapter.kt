package com.example.designtest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.R
import com.example.designtest.data.MusicItem
import com.google.android.material.card.MaterialCardView

class PlaylistsAdapter(
    private val playlists: List<Playlist>,
    private val onItemClick: (Playlist) -> Unit = {}
) : RecyclerView.Adapter<PlaylistsAdapter.ViewHolder>() {

    data class Playlist(
        val name: String,
        val songs: List<MusicItem>,
        val coverArt: Int? = null
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val coverImage: ImageView = view.findViewById(R.id.coverImage)
        val playlistName: TextView = view.findViewById(R.id.playlistName)
        val songCount: TextView = view.findViewById(R.id.songCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_playlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playlist = playlists[position]
        
        holder.playlistName.text = playlist.name
        holder.songCount.text = "${playlist.songs.size} songs"
        
        // Set cover art if available, otherwise use placeholder
        playlist.coverArt?.let { 
            holder.coverImage.setImageResource(it)
        }
        
        holder.cardView.setOnClickListener { onItemClick(playlist) }
    }

    override fun getItemCount() = playlists.size
}
