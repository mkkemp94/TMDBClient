package com.mkemp.tmdbclient.data.repository.tvshow.datasource

import com.mkemp.tmdbclient.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB() : List<TVShow>
    suspend fun saveTVShowsToDB(tvShows : List<TVShow>)
    suspend fun clearAll()
}