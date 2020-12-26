package com.mkemp.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.mkemp.tmdbclient.data.db.ArtistDao
import com.mkemp.tmdbclient.data.db.MovieDao
import com.mkemp.tmdbclient.data.db.TMDBDatabase
import com.mkemp.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule
{
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context) : TMDBDatabase
    {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao
    {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTVDao(tmdbDatabase: TMDBDatabase): TVShowDao
    {
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao
    {
        return tmdbDatabase.artistDao()
    }
}