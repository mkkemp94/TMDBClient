package com.mkemp.tmdbclient.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * This Data Class is being used for Artists coming from retrofit calls
 * AND ALSO for room database
 */
@Entity(tableName = "popular_artists")
data class Artist(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String

)