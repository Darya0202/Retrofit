package com.example.retrofit.screens.weather.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.ItemWeatherBinding

class WeatherAdapter(
    private val onItemClick: (String) -> Unit
):RecyclerView.Adapter<WeatherAdapter.HomeViewHolder>() {

    private var listHome = listOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun setCityList(list: List<String>) {
        listHome = list
        notifyDataSetChanged()
    }

    class HomeViewHolder(val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listHome.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val city = listHome[position]
        holder.binding.city.text = city

        holder.itemView.setOnClickListener {
            onItemClick(city)
        }
    }
}