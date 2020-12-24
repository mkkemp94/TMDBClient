package com.mkemp.tmdbclient.domain.repository

import com.mkemp.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?

    suspend fun updateArtists() : List<Artist>?

}