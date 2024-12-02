package com.example.designtest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.R
import com.example.designtest.data.MusicItem
import com.google.android.material.card.MaterialCardView

class SongsAdapter(
    private val songs: List<MusicItem>,
    private val onItemClick: (MusicItem) -> Unit = {}
) : RecyclerView.Adapter<SongsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val songImage: ImageView = view.findViewById(R.id.songImage)
        val songTitle: TextView = view.findViewById(R.id.songTitle)
        val artistName: TextView = view.findViewById(R.id.artistName)
        val duration: TextView = view.findViewById(R.id.duration)
        val favoriteButton: ImageButton = view.findViewById(R.id.favoriteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]
        
        holder.songTitle.text = song.title
        holder.artistName.text = song.artist
        holder.duration.text = song.duration
        
        // Set favorite icon based on status
        holder.favoriteButton.setImageResource(
            if (song.isFavorite) R.drawable.ic_favorite
            else R.drawable.ic_favorite_border
        )
        
        // Handle clicks
        holder.cardView.setOnClickListener { onItemClick(song) }
        holder.favoriteButton.setOnClickListener {
            // Toggle favorite status
            song.isFavorite = !song.isFavorite
            notifyItemChanged(position)
        }
    }

    override fun getItemCount() = songs.size
}
