package com.mkemp.tmdbclient.presentation.di.core

import com.mkemp.tmdbclient.domain.repository.ArtistRepository
import com.mkemp.tmdbclient.domain.repository.MovieRepository
import com.mkemp.tmdbclient.domain.repository.TVShowRepository
import com.mkemp.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule
{
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase
    {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase
    {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowsUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase
    {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowsUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase
    {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase
    {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase
    {
        return UpdateArtistsUseCase(artistRepository)
    }
}