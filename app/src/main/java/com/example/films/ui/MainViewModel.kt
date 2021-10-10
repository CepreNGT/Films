package com.example.films.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.films.AppState
import com.example.films.model.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {
    private val liveData = MutableLiveData<AppState>()

    fun getLiveData(): LiveData<AppState> = liveData

    fun getFilm() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveData.value = AppState.Loading
        Thread {
            liveData.postValue(AppState.Success(repository.getFilmDataFromLocalStorage()))
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        Log.i("LifecycleEvent", "onStart")
    }
}