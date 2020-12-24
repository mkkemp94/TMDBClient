package com.mkemp.tmdbclient.data.repository.tvshow

import android.util.Log
import com.mkemp.tmdbclient.data.model.tvshow.TVShow
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.mkemp.tmdbclient.domain.repository.TVShowRepository
import java.lang.Exception

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {

    override suspend fun getTVShows(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newTVShows = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newTVShows)
        tvShowCacheDataSource.saveTVShowsToCache(newTVShows)
        return newTVShows
    }

    private suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        try {

            val result = tvShowRemoteDataSource.getTVShows()
            val body = result.body()
            if (body != null) {
                tvShows = body.TVShows
            }

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return tvShows
    }

    private suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        try {

            tvShows = tvShowLocalDataSource.getTVShowsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if (tvShows.isNotEmpty()) {
            return tvShows
        } else {
            tvShows = getTVShowsFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShows)
        }

        return tvShows
    }

    private suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShows: List<TVShow>

        try {

            tvShows = tvShowCacheDataSource.getTVShowsFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if (tvShows.isNotEmpty()) {
            return tvShows
        } else {
            tvShows = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShows)
        }

        return tvShows
    }

}