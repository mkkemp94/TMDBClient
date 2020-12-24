package com.mkemp.tmdbclient.data.repository.artist.datasource

import com.mkemp.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artistList: List<Artist>)
    suspend fun clearAll()
}