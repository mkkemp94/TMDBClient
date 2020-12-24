package com.mkemp.tmdbclient.data.repository.movie.datasourceimpl

import com.mkemp.tmdbclient.data.db.MovieDao
import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    // Room automatically executes this on a background thread
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        // We need to specifically do this on a background thread
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        // We need to specifically do this on a background thread
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }

}