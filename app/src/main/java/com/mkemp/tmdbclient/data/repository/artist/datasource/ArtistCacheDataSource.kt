package com.mkemp.tmdbclient.data.repository.artist.datasource

import com.mkemp.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artistList: List<Artist>)
}