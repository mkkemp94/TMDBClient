package com.mkemp.tmdbclient.presentation.di.core

import com.mkemp.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.mkemp.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.mkemp.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.TVShowRepositoryImpl
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.mkemp.tmdbclient.domain.repository.ArtistRepository
import com.mkemp.tmdbclient.domain.repository.MovieRepository
import com.mkemp.tmdbclient.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule
{
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository
    {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository
    {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository
    {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}