package com.example.designtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designtest.R
import com.example.designtest.adapters.SongsAdapter
import com.example.designtest.data.DummyData
import com.example.designtest.utils.AnimationUtils
import com.google.android.material.snackbar.Snackbar

class SongsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SongsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.songsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        
        adapter = SongsAdapter(DummyData.allSongs) { song ->
            Snackbar.make(view, "Playing ${song.title}", Snackbar.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        // Run the layout animation
        AnimationUtils.runLayoutAnimation(recyclerView)
    }

    fun refreshList() {
        // Call this when you want to re-run the animation
        AnimationUtils.runLayoutAnimation(recyclerView)
    }

    companion object {
        fun newInstance() = SongsFragment()
    }
}
