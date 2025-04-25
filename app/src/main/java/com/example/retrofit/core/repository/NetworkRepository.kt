package com.example.retrofit.core.repository

import com.example.retrofit.core.model.WeatherResponse
import retrofit2.Response

interface NetworkRepository {

    suspend fun getWeather(city: String): Response<WeatherResponse>
}