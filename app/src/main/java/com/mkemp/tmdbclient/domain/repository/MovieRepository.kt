package com.mkemp.tmdbclient.domain.repository

import com.mkemp.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?

}