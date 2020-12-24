package com.mkemp.tmdbclient.domain.usecase

import com.mkemp.tmdbclient.data.model.tvshow.TVShow
import com.mkemp.tmdbclient.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute() : List<TVShow>? = tvShowRepository.updateTVShows()

}