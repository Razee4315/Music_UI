package com.example.designtest.data

data class MusicItem(
    val id: Long,
    val title: String,
    val artist: String,
    val duration: String,
    val albumArt: Int? = null,
    var isFavorite: Boolean = false
)
