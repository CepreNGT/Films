package com.example.films.ui

import androidx.lifecycle.*
import com.example.films.AppState
import com.example.films.model.repository.Repository
import com.example.films.model.repository.RepositoryImpl

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveData

    fun getFilm(apiKey: String) = getDataFromLocalSource(apiKey)

    private fun getDataFromLocalSource(apiKey: String) {
        with (liveData) {
            value = AppState.Loading
            Thread {
                postValue(AppState.Success(repository.getFilmDataFromServer(apiKey)))
            }.start()
        }
    }
}