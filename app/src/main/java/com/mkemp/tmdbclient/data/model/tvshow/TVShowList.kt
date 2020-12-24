package com.mkemp.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.mkemp.tmdbclient.data.model.tvshow.TVShow

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)