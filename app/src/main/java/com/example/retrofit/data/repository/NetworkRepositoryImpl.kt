package com.example.retrofit.data.repository

import com.example.retrofit.core.repository.NetworkRepository
import com.example.retrofit.core.model.WeatherResponse
import com.example.retrofit.data.api.WeatherApi
import retrofit2.Response

class NetworkRepositoryImpl(private val api: WeatherApi): NetworkRepository {

    override suspend fun getWeather(city: String): Response<WeatherResponse> {
        return api.getWeather(city)
    }
}
