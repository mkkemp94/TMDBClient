package com.mkemp.tmdbclient.presentation.di.core

import com.mkemp.tmdbclient.data.api.TMDBService
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String)
{
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource
    {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource
    {
        return TVShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource
    {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}