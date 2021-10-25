package com.example.films.model.repository

import com.example.films.model.FilmLoader
import com.example.films.model.entities.Film
import com.example.films.model.entities.getFilms
import com.example.films.model.server.FilmDTO

class RepositoryImpl : Repository {
    override fun getFilmDataFromServer(apiKey: String): List<Film> {
        val films = ArrayList<Film>()
        val onLoadListener: FilmLoader.FilmLoaderListener =
            object : FilmLoader.FilmLoaderListener {
                override fun onLoaded(dtoList: ArrayList<FilmDTO>) {
                    for (dto in dtoList) {
                        films.add(
                            Film(
                                title = dto.fact?.title,
                                genre = dto.fact?.genre,
                                budget = dto.fact?.budget,
                                overView = dto.fact?.overView,
                                date = dto.fact?.date,
                                duration = dto.fact?.duration,
                                rating = dto.fact?.rating
                            )
                        )
                    }
                }
                override fun onFailed(throwable: Throwable) {}
            }
        val loader = FilmLoader(onLoadListener, 2, 10, apiKey)
        loader.loadFilm()
        return films
    }

    override fun getFilmDataFromLocalStorage() = getFilms()
}