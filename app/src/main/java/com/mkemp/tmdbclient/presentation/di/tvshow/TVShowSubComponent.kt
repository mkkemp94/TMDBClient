package com.mkemp.tmdbclient.presentation.di.tvshow

import com.mkemp.tmdbclient.presentation.tv.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent
{
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory
    {
        fun create() : TVShowSubComponent
    }
}