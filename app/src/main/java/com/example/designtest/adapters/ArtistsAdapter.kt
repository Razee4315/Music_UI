package com.example.designtest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.R
import com.google.android.material.card.MaterialCardView

class ArtistsAdapter(
    private val artists: List<Artist>,
    private val onItemClick: (Artist) -> Unit = {}
) : RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {

    data class Artist(
        val name: String,
        val songCount: Int,
        val albumCount: Int,
        val image: Int? = null
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val artistImage: ImageView = view.findViewById(R.id.artistImage)
        val artistName: TextView = view.findViewById(R.id.artistName)
        val songCount: TextView = view.findViewById(R.id.songCount)
        val albumCount: TextView = view.findViewById(R.id.albumCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists[position]
        
        holder.artistName.text = artist.name
        holder.songCount.text = "${artist.songCount} songs"
        holder.albumCount.text = "${artist.albumCount} albums"
        
        // Set artist image if available, otherwise use placeholder
        artist.image?.let { 
            holder.artistImage.setImageResource(it)
        }
        
        holder.cardView.setOnClickListener { onItemClick(artist) }
    }

    override fun getItemCount() = artists.size
}
