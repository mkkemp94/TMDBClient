package com.mkemp.tmdbclient.data.repository.movie.datasourceimpl

import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

/**
 * This class uses a very basic caching mechanism
 */
class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

}