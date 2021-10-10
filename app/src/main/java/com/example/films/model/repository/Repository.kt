package com.example.films.model.repository

import com.example.films.model.entities.Film

interface Repository {
    fun getFilmDataFromServer(): Film
    fun getFilmDataFromLocalStorage(): Film
}