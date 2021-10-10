package com.example.films

import com.example.films.model.entities.Film

sealed class AppState {
    data class Success(val filmData: Film) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}