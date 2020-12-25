package com.mkemp.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mkemp.tmdbclient.domain.usecase.GetArtistsUseCase
import com.mkemp.tmdbclient.domain.usecase.GetMoviesUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.mkemp.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}