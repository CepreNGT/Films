package com.example.films.model.server

data class FactDTO(
    val title: String?,
    val genre: String?,
    val budget: Long?,
    val overView: String?,
    val date: String?,
    val duration: String?,
    val rating: Double?
)
