package com.mkemp.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.repository.movie.FakeMovieRepository
import com.mkemp.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.mkemp.tmdbclient.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest
{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp()
    {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList()
    {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterpath1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "posterpath2", "date2", "title2"))
        movies.add(Movie(3, "overview3", "posterpath3", "date3", "title3"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList()
    {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "posterpath3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "posterpath4", "date4", "title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}