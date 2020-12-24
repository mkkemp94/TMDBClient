package com.mkemp.tmdbclient.data.repository.artist

import android.util.Log
import com.mkemp.tmdbclient.data.model.artist.Artist
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.mkemp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.mkemp.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList)
        artistCacheDataSource.saveArtistsToCache(newArtistList)
        return newArtistList
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {

            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {

            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist>? {
        lateinit var artistList: List<Artist>

        try {

            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }

}