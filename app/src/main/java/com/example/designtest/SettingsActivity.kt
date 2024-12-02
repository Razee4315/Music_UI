package com.example.designtest

import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Set up back button click
        findViewById<ImageButton>(R.id.backButton)?.setOnClickListener {
            finish()
        }

        // Set up settings option clicks
        setupSettingsClickListeners()
    }

    private fun setupSettingsClickListeners() {
        // Look and feel click
        findViewById<LinearLayout>(R.id.lookAndFeelOption)?.setOnClickListener {
            // Add your look and feel settings logic here
        }

        // Now playing click
        findViewById<LinearLayout>(R.id.nowPlayingOption)?.setOnClickListener {
            // Add your now playing settings logic here
        }

        // Audio click
        findViewById<LinearLayout>(R.id.audioOption)?.setOnClickListener {
            // Add your audio settings logic here
        }

        // Other settings options...
    }
}
