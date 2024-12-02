package com.example.designtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.data.MusicItem
import com.google.android.material.card.MaterialCardView

class TrendingAdapter(
    private val items: List<MusicItem>,
    private val onItemClick: (MusicItem) -> Unit = {}
) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: MaterialCardView = view.findViewById(R.id.cardView)
        val titleText: TextView = view.findViewById(R.id.titleText)
        val artistText: TextView = view.findViewById(R.id.artistText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trending, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleText.text = item.title
        holder.artistText.text = item.artist
        holder.cardView.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = items.size
}
