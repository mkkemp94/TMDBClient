package com.mkemp.tmdbclient.domain.usecase

import com.mkemp.tmdbclient.data.model.artist.Artist
import com.mkemp.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute() : List<Artist>? = artistRepository.updateArtists()

}