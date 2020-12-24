package com.mkemp.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.model.tvshow.TVShow

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TVShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTVShows(tvShows: List<TVShow>)

}