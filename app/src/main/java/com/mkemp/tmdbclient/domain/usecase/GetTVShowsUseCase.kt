package com.mkemp.tmdbclient.domain.usecase

import com.mkemp.tmdbclient.data.model.tvshow.TVShow
import com.mkemp.tmdbclient.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute() : List<TVShow>? = tvShowRepository.getTVShows()

}