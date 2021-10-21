package com.example.films.model.repository

import com.example.films.model.FilmLoader
import com.example.films.model.entities.Film
import com.example.films.model.entities.getFilms

class RepositoryImpl : Repository {
    override fun getFilmDataFromServer(apiKey: String): List<Film> {
        val films = ArrayList<Film>()
        for (id in 2..10) {
            val dto = FilmLoader.loadFilm(id, apiKey)
            films.add(Film(
                title = dto?.fact?.title,
                genre = dto?.fact?.genre,
                budget = dto?.fact?.budget,
                overView = dto?.fact?.overView,
                date = dto?.fact?.date,
                duration = dto?.fact?.duration,
                rating = dto?.fact?.rating
            ))
        }
        return films
    }

    override fun getFilmDataFromLocalStorage() = getFilms()
}