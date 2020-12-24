package com.mkemp.tmdbclient.data.repository.artist.datasourceimpl

import com.mkemp.tmdbclient.data.db.ArtistDao
import com.mkemp.tmdbclient.data.model.artist.Artist
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artistList: List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveArtists(artistList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtists()
        }
    }

}