package com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl

import com.mkemp.tmdbclient.data.api.TMDBService
import com.mkemp.tmdbclient.data.model.tvshow.TVShowList
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }
}