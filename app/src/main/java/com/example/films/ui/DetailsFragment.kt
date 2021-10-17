package com.example.films.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.films.R
import com.example.films.databinding.FragmentDetailsBinding
import com.example.films.model.entities.Film
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Film>(BUNDLE_EXTRA)?.let {
            with(binding) {
                filmTitle.text = it.title
                filmOverview.text = it.overView
                filmGenre.text = it.genre
                filmBudget.text = it.budget.toString()
                filmDate.text = it.date
                filmDuration.text = it.duration
                filmRating.text = it.rating.toString()
                genreTextView.text = getString(R.string.genre)
                budgetTextView.text = getString(R.string.budget)
                dateTextView.text = getString(R.string.date)
                durationTextView.text = getString(R.string.duration)
                ratingTextView.text = getString(R.string.rating)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "FILM"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}