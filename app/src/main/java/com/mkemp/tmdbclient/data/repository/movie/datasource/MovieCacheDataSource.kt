package com.mkemp.tmdbclient.data.repository.movie.datasource

import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)

}