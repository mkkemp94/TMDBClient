package com.mkemp.tmdbclient.presentation.di.tvshow

import com.mkemp.tmdbclient.domain.usecase.*
import com.mkemp.tmdbclient.presentation.tv.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule
{
    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory
    {
        return TVShowViewModelFactory(getTVShowsUseCase, updateTVShowsUseCase)
    }
}