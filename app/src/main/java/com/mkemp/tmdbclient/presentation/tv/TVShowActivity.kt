package com.mkemp.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mkemp.tmdbclient.R
import com.mkemp.tmdbclient.databinding.ActivityHomeBinding
import com.mkemp.tmdbclient.databinding.ActivityTvShowBinding

class TVShowActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}