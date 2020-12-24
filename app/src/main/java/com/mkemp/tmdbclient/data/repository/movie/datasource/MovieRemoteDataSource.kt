package com.mkemp.tmdbclient.data.repository.movie.datasource

import com.mkemp.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>

}