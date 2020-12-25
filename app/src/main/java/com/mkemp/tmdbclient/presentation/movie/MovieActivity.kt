package com.mkemp.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mkemp.tmdbclient.R
import com.mkemp.tmdbclient.databinding.ActivityHomeBinding
import com.mkemp.tmdbclient.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}