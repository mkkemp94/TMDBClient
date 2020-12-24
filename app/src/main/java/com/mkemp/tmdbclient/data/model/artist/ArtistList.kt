package com.mkemp.tmdbclient.data.model.artist


import com.google.gson.annotations.SerializedName
import com.mkemp.tmdbclient.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)