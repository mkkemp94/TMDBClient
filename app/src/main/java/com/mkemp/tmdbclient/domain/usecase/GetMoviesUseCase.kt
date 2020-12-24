package com.mkemp.tmdbclient.domain.usecase

import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.getMovies()

}