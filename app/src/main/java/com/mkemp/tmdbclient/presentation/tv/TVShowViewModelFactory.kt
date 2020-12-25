package com.mkemp.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mkemp.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.GetTVShowsUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}