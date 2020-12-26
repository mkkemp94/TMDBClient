package com.mkemp.tmdbclient.presentation.di.movie

import com.mkemp.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.mkemp.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule
{
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory
    {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}