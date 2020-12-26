package com.mkemp.tmdbclient.presentation.di.core

import com.mkemp.tmdbclient.data.api.TMDBService
import com.mkemp.tmdbclient.data.db.ArtistDao
import com.mkemp.tmdbclient.data.db.MovieDao
import com.mkemp.tmdbclient.data.db.TVShowDao
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.mkemp.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.mkemp.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowLocalDataSourceImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule
{
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource
    {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource
    {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource
    {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}