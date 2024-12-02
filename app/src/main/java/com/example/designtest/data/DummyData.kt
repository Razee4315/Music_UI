package com.example.designtest.data

object DummyData {
    val recentSearches = listOf(
        "Ed Sheeran", "Taylor Swift", "Rock Classics", "Workout Mix", "Chill Vibes",
        "Hip Hop Hits", "Summer Playlist", "Road Trip Songs"
    )

    val trendingSearches = listOf(
        "Cruel Summer - Taylor Swift",
        "Vampire - Olivia Rodrigo",
        "Last Night - Morgan Wallen",
        "Rich Flex - Drake & 21 Savage",
        "Anti-Hero - Taylor Swift",
        "As It Was - Harry Styles",
        "About Damn Time - Lizzo",
        "Bad Habit - Steve Lacy"
    )

    val allSongs = listOf(
        MusicItem(1L, "Shape of You", "Ed Sheeran", duration = "3:53"),
        MusicItem(2L, "Cruel Summer", "Taylor Swift", duration = "2:58", isFavorite = true),
        MusicItem(3L, "Blinding Lights", "The Weeknd", duration = "3:20"),
        MusicItem(4L, "As It Was", "Harry Styles", duration = "2:47", isFavorite = true),
        MusicItem(5L, "Flowers", "Miley Cyrus", duration = "3:21"),
        MusicItem(6L, "Anti-Hero", "Taylor Swift", duration = "3:20", isFavorite = true),
        MusicItem(7L, "Last Night", "Morgan Wallen", duration = "2:43"),
        MusicItem(8L, "Rich Flex", "Drake & 21 Savage", duration = "3:59")
    )

    val playlists = listOf(
        "Summer Vibes 2023" to listOf(
            allSongs[0], allSongs[1], allSongs[4], allSongs[5]
        ),
        "Workout Mix" to listOf(
            allSongs[2], allSongs[3], allSongs[6], allSongs[7]
        ),
        "Chill Evening" to listOf(
            allSongs[1], allSongs[3], allSongs[5], allSongs[0]
        ),
        "Party Hits" to listOf(
            allSongs[7], allSongs[4], allSongs[2], allSongs[6]
        )
    )

    val favoriteArtists = listOf(
        "Taylor Swift",
        "Ed Sheeran",
        "The Weeknd",
        "Harry Styles",
        "Drake",
        "Miley Cyrus"
    )

    val recentlyPlayed = listOf(
        allSongs[1], allSongs[3], allSongs[5], allSongs[0],
        allSongs[2], allSongs[4], allSongs[6], allSongs[7]
    )

    val favorites = allSongs.filter { it.isFavorite }

    val categories = listOf(
        "Pop" to listOf(allSongs[0], allSongs[1], allSongs[4]),
        "Rock" to listOf(allSongs[2], allSongs[5]),
        "Hip Hop" to listOf(allSongs[7], allSongs[6]),
        "Indie" to listOf(allSongs[3])
    )

    val topCharts = listOf(
        "Global Top 50" to listOf(allSongs[1], allSongs[3], allSongs[5]),
        "US Top 50" to listOf(allSongs[0], allSongs[2], allSongs[4]),
        "Viral Hits" to listOf(allSongs[6], allSongs[7], allSongs[1])
    )

    fun searchSongs(query: String): List<MusicItem> {
        return allSongs.filter { song ->
            song.title.contains(query, ignoreCase = true) ||
            song.artist.contains(query, ignoreCase = true)
        }
    }
}
