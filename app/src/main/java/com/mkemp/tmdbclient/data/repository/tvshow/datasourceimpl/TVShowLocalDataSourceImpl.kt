package com.mkemp.tmdbclient.data.repository.tvshow.datasourceimpl

import com.mkemp.tmdbclient.data.db.TVShowDao
import com.mkemp.tmdbclient.data.model.tvshow.TVShow
import com.mkemp.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {

    override suspend fun getTVShowsFromDB(): List<TVShow> = tvShowDao.getTVShows()

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowDao.deleteAllTVShows()
        }
    }

}