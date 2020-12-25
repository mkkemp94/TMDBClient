package com.mkemp.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mkemp.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.GetTVShowsUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel()
{
    fun getTVShows() = liveData {
        val tvShowList = getTVShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTVShows() = liveData {
        val tvShowList = updateTVShowsUseCase.execute()
        emit(tvShowList)
    }
}