package com.example.designtest

import android.os.Bundle
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NowPlayingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_now_playing)

        // Set up close button click
        findViewById<ImageButton>(R.id.closeButton)?.setOnClickListener {
            finish()
        }

        // Set up player controls
        setupPlayerControls()
    }

    private fun setupPlayerControls() {
        // Play/Pause button click
        findViewById<FloatingActionButton>(R.id.playPauseButton)?.setOnClickListener {
            // Add your play/pause logic here
        }

        // Previous button click
        findViewById<ImageButton>(R.id.previousButton)?.setOnClickListener {
            // Add your previous track logic here
        }

        // Next button click
        findViewById<ImageButton>(R.id.nextButton)?.setOnClickListener {
            // Add your next track logic here
        }

        // Seek bar change
        findViewById<SeekBar>(R.id.seekBar)?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    // Add your seek logic here
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Set up bottom action buttons
        setupBottomActions()
    }

    private fun setupBottomActions() {
        // Repeat button
        findViewById<ImageButton>(R.id.repeatButton)?.setOnClickListener {
            // Add your repeat logic here
        }

        // Favorite button
        findViewById<ImageButton>(R.id.favoriteButton)?.setOnClickListener {
            // Add your favorite logic here
        }

        // Playlist button
        findViewById<ImageButton>(R.id.playlistButton)?.setOnClickListener {
            // Add your playlist logic here
        }
    }
}
