package com.mkemp.tmdbclient.data


import com.google.gson.annotations.SerializedName
import com.mkemp.tmdbclient.data.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)