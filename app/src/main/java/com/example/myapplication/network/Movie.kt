package com.example.myapplication.network

import com.squareup.moshi.Json

data class Movies(
    @Json(name= "results") val results : List<Movie>
)
data class Movie(val id: String,
                 val title: String,
                 @Json(name= "poster_path") val posterPath: String)