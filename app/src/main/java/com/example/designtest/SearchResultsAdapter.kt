package com.example.designtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.data.MusicItem
import com.google.android.material.card.MaterialCardView

class SearchResultsAdapter(
    private val items: List<MusicItem>,
    private val onItemClick: (MusicItem) -> Unit = {}
) : RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val titleText: TextView = view.findViewById(R.id.titleText)
        val subtitleText: TextView = view.findViewById(R.id.subtitleText)
        val durationText: TextView = view.findViewById(R.id.durationText)
        val favoriteIcon: ImageView = view.findViewById(R.id.favoriteIcon)
        val menuButton: ImageButton = view.findViewById(R.id.menuButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        
        holder.titleText.text = item.title
        holder.subtitleText.text = item.artist
        holder.durationText.text = item.duration
        
        holder.favoriteIcon.visibility = if (item.isFavorite) View.VISIBLE else View.GONE
        
        holder.cardView.setOnClickListener { onItemClick(item) }
        holder.menuButton.setOnClickListener {
            // Handle menu button click
            // Show options menu with Play, Add to playlist, etc.
        }
    }

    override fun getItemCount() = items.size
}
