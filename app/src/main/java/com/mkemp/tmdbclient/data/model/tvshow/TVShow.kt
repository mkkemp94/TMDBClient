package com.mkemp.tmdbclient.data.model.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tv_shows")
data class TVShow(

    @SerializedName("first_air_date")
    val firstAirDate: String,
    @PrimaryKey // for room
    @SerializedName("id") // for retrofit
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String

)