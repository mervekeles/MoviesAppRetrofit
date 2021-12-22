package com.example.myapplication.movielist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMovieListBinding


class MovieListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  binding : FragmentMovieListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)

        binding.lifecycleOwner = this


        val application = requireNotNull(this.activity).application
        val movieListViewModel: MovieListViewModel by viewModels(){ MovieListViewModelFactory(application) }

        binding.viewModel = movieListViewModel

        val adapter = MovieListAdapter()
        binding.rv.adapter = adapter


        return binding.root
    }
}