package com.mkemp.tmdbclient.presentation.di.artist

import com.mkemp.tmdbclient.domain.usecase.GetArtistsUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.mkemp.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule
{
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory
    {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}