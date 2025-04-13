package com.example.retrofit.screens.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ItemLayoutBinding
import com.example.retrofit.model.WeatherResponse


class HomeAdapter:RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var list_home = emptyList<WeatherResponse>()


    class HomeViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list_home.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.city.text = list_home[position].location.name
        holder.binding.weatherDescriptions.text = list_home[position].current.weatherDescriptions.firstOrNull() ?: ""
        holder.binding.degrees.text = "${list_home[position].current.temperature}°C"

        Glide.with(holder.binding.image.context)
            .load(list_home[position].current.weatherIcons.firstOrNull())
            .into(holder.binding.image)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<WeatherResponse>){
        list_home = list
        notifyDataSetChanged()
    }
}