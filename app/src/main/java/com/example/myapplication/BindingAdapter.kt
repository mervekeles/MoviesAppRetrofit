package com.example.myapplication

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.movielist.MovieListAdapter
import com.example.myapplication.network.Movie

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){

    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView)
            .load(imgUri)
            .into(imgView)
    }

}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?){

    val adapter = recyclerView.adapter as MovieListAdapter
    adapter.submitList(data)
}