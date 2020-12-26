package com.mkemp.tmdbclient.presentation

import android.app.Application
import com.mkemp.tmdbclient.BuildConfig
import com.mkemp.tmdbclient.presentation.di.Injector
import com.mkemp.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.mkemp.tmdbclient.presentation.di.core.*
import com.mkemp.tmdbclient.presentation.di.movie.MovieSubComponent
import com.mkemp.tmdbclient.presentation.di.tvshow.TVShowSubComponent

class App : Application(), Injector
{
    private lateinit var appComponent: AppComponent

    override fun onCreate()
    {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent
    {
        return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent
    {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent
    {
        return appComponent.artistSubComponent().create()
    }
}