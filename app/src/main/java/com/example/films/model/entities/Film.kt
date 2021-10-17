package com.example.films.model.entities

import kotlin.collections.ArrayList

data class Film(
    val title: String = "Fight Club",
    val genre: String = "Drama",
    val budget: Long = 63000000L,
    val overView: String = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
    val date: String = "1999-10-15",
    val duration: String = "2h 19m",
    val rating: Double = 8.4,
)