package com.mkemp.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mkemp.tmdbclient.R
import com.mkemp.tmdbclient.data.model.movie.Movie
import com.mkemp.tmdbclient.data.model.tvshow.TVShow
import com.mkemp.tmdbclient.databinding.ListItemBinding

class TVShowAdapter : RecyclerView.Adapter<MyViewHolder>()
{
    private val tvShowList = ArrayList<TVShow>()

    fun setList(tvShows: List<TVShow>)
    {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int
    {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.bind(tvShowList[position])
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(tvShow: TVShow)
    {
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}