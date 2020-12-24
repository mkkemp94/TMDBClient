package com.mkemp.tmdbclient.domain.repository

import com.mkemp.tmdbclient.data.model.tvshow.TVShow

interface TVShowRepository {

    suspend fun getTVShows() : List<TVShow>?

    suspend fun updateTVShows() : List<TVShow>?

}