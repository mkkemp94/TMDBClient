package com.mkemp.tmdbclient.presentation.di.core

import android.content.Context
import com.mkemp.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.mkemp.tmdbclient.presentation.di.movie.MovieSubComponent
import com.mkemp.tmdbclient.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    TVShowSubComponent::class,
    ArtistSubComponent::class
])
class AppModule(private val context: Context)
{
    @Singleton
    @Provides
    fun provideApplicationContext() : Context {
        return context.applicationContext
    }
}