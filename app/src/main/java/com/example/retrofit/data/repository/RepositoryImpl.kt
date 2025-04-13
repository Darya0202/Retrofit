package com.example.retrofit.data.repository

import com.example.retrofit.data.api.RetrofitInstance.api
import com.example.retrofit.model.WeatherResponse

class RepositoryImpl {

    suspend fun getWeather(): ArrayList<WeatherResponse> {
        val cities = listOf(
            "Moscow",
            "Volgograd",
            "Saint Petersburg",
            "Kazan",
            "Tokio",
            "Madrid",
            "Istanbul",
            "Beijing",
            "Seoul",
            "New York",
            "Toronto",
            "London",
            "Mumbai",
            "Paris",
            "Rome",)
        val list = arrayListOf<WeatherResponse>()

        for (city in cities) {
            val response = api.getWeather(city = city)
            if (response.isSuccessful) {
                response.body()?.let {
                    list.add(it)
                }
            }
        }

        return list
    }

}