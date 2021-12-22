package com.example.myapplication.movielist

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ListItemMovieBinding
import com.example.myapplication.network.Movie

class MovieListAdapter : ListAdapter<Movie, MovieListAdapter.ViewHolder>(DiffCallback) {

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder.from(parent)
        }

    companion object DiffCallback: DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

    }



        class ViewHolder (val binding: ListItemMovieBinding) : RecyclerView.ViewHolder(binding.root){

            fun bind(movie: Movie) {
                binding.movie = movie
                binding.executePendingBindings()
            }

            companion object {
                fun from(parent: ViewGroup): ViewHolder {
                    val binding = ListItemMovieBinding.inflate(LayoutInflater.from(parent.context))

                    return ViewHolder(binding)
                }
            }
        }
    }

