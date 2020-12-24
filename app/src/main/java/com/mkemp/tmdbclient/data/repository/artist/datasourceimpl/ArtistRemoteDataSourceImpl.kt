package com.mkemp.tmdbclient.data.repository.artist.datasourceimpl

import com.mkemp.tmdbclient.data.api.TMDBService
import com.mkemp.tmdbclient.data.model.artist.ArtistList
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String) : ArtistRemoteDataSource {

    override suspend fun getArtists() : Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }

}