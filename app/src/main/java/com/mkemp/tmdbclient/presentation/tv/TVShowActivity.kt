package com.mkemp.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkemp.tmdbclient.R
import com.mkemp.tmdbclient.databinding.ActivityTvShowBinding
import com.mkemp.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TVShowActivity : AppCompatActivity()
{
    @Inject
    lateinit var factory: TVShowViewModelFactory
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTVShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TVShowViewModel::class.java)

        initRecyclerView()
        displayPopularArtists()
    }

    private fun initRecyclerView()
    {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TVShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
    }

    private fun displayPopularArtists()
    {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        tvShowViewModel.getTVShows().observe(this, Observer {
            if (it != null)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }
            else
            {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {
            R.id.action_update ->
            {
                updateTVShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTVShows()
    {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        tvShowViewModel.updateTVShows().observe(this, Observer {
            if (it != null)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }
            else
            {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}