package com.mkemp.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mkemp.tmdbclient.data.model.artist.Artist
import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun tvDao() : TVShowDao
    abstract fun artistDao() : ArtistDao

}