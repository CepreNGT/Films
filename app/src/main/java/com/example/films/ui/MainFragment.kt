package com.example.films.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.films.AppState
import com.example.films.R
import com.example.films.databinding.MainFragmentBinding
import com.example.films.model.entities.Film
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle.addObserver(viewModel)

        val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilm()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val weatherData = appState.filmData
                progressBar.visibility = View.GONE
                filmGroup.visibility = View.VISIBLE
                setData(weatherData)
            }
            is AppState.Loading -> {
                filmGroup.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                filmGroup.visibility = View.INVISIBLE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getFilm() }
                    .show()
            }
        }
    }

    private fun setData(filmData: Film) = with(binding) {
        filmTitle.text = filmData.title
        filmOverview.text = filmData.overView
        filmGenre.text = filmData.genre
        filmBudget.text = filmData.budget.toString()
        filmDate.text = filmData.date
        filmDuration.text = filmData.duration
        filmRating.text = filmData.rating.toString()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}