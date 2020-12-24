package com.mkemp.tmdbclient.data.repository.tvshow.datasource

import com.mkemp.tmdbclient.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache() : List<TVShow>
    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)
}