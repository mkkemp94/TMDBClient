package com.mkemp.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mkemp.tmdbclient.R
import com.mkemp.tmdbclient.databinding.ActivityArtistBinding
import com.mkemp.tmdbclient.databinding.ActivityHomeBinding

class ArtistActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}