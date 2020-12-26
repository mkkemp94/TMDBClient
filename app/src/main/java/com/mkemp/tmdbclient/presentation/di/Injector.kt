package com.mkemp.tmdbclient.presentation.di

import com.mkemp.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.mkemp.tmdbclient.presentation.di.movie.MovieSubComponent
import com.mkemp.tmdbclient.presentation.di.tvshow.TVShowSubComponent

interface Injector
{
    fun createMovieSubComponent(): MovieSubComponent
    fun createTVShowSubComponent(): TVShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}