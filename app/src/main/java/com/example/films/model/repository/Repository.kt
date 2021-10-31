package com.example.films.model.repository

import com.example.films.model.entities.Film

interface Repository {
    fun getFilmDataFromServer(apiKey: String): List<Film>
    fun getFilmDataFromLocalStorage(): List<Film>
}