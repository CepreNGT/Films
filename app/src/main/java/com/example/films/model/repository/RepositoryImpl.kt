package com.example.films.model.repository

import com.example.films.model.entities.Film

class RepositoryImpl : Repository {
    override fun getFilmDataFromServer() = Film()

    override fun getFilmDataFromLocalStorage() = Film()
}