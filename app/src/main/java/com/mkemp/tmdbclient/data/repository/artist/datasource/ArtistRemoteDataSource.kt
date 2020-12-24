package com.mkemp.tmdbclient.data.repository.artist.datasource

import com.mkemp.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}