package com.example.films.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val title: String? = "Fight Club",
    val genre: String? = "Drama",
    val budget: Long? = 63000000L,
    val overView: String? = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
    val date: String? = "1999-10-15",
    val duration: String? = "2h 19m",
    val rating: Double? = 8.4
) : Parcelable

fun getFilms() = listOf(
        Film("First", "Comedy", 356287L, "Really interesting film", "1999-10-20", "5h 10m", 7.0),
        Film("Second", "Romantic", 4356L, "Really funny film", "1998-10-21", "4h 10m", 7.6),
        Film("Third", "Documentary", 777729L, "Really wonderful film", "1997-10-22", "3h 10m", 8.0),
        Film("Fourth", "Drama", 29837L, "Really amazing film", "1996-10-23", "2h 10m", 9.7),
        Film("Fifth", "Action", 345678902L, "Really exciting film", "1995-10-24", "1h 10m", 10.0)
    )