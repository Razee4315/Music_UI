package com.example.designtest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.R
import com.google.android.material.card.MaterialCardView

class AlbumsAdapter(
    private val albums: List<Album>,
    private val onItemClick: (Album) -> Unit = {}
) : RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {

    data class Album(
        val name: String,
        val artist: String,
        val songCount: Int,
        val coverArt: Int? = null
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val coverImage: ImageView = view.findViewById(R.id.coverImage)
        val albumName: TextView = view.findViewById(R.id.albumName)
        val artistName: TextView = view.findViewById(R.id.artistName)
        val songCount: TextView = view.findViewById(R.id.songCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        
        holder.albumName.text = album.name
        holder.artistName.text = album.artist
        holder.songCount.text = "${album.songCount} songs"
        
        // Set cover art if available, otherwise use placeholder
        album.coverArt?.let { 
            holder.coverImage.setImageResource(it)
        }
        
        holder.cardView.setOnClickListener { onItemClick(album) }
    }

    override fun getItemCount() = albums.size
}
