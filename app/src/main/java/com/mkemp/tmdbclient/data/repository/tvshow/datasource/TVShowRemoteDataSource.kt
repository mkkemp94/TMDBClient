package com.mkemp.tmdbclient.data.repository.tvshow.datasource

import com.mkemp.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows() : Response<TVShowList>
}