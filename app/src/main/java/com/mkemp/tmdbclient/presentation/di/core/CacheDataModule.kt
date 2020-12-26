package com.mkemp.tmdbclient.presentation.di.core

import com.mkemp.tmdbclient.data.api.TMDBService
import com.mkemp.tmdbclient.data.db.ArtistDao
import com.mkemp.tmdbclient.data.db.MovieDao
import com.mkemp.tmdbclient.data.db.TVShowDao
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.mkemp.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.mkemp.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.mkemp.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.mkemp.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowCacheDataSourceImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowLocalDataSourceImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule()
{
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource
    {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVCacheDataSource(): TVShowCacheDataSource
    {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource
    {
        return ArtistCacheDataSourceImpl()
    }
}