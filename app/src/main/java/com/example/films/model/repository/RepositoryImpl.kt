package com.example.films.model.repository

import com.example.films.model.entities.Film
import com.example.films.model.entities.getFilms

class RepositoryImpl : Repository {
    override fun getFilmDataFromServer() = Film()

    override fun getFilmDataFromLocalStorage() = getFilms()
}