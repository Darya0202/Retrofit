package com.example.retrofit.core.repository

import com.example.retrofit.core.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkRepository {
    suspend fun getWeather(city: String): Response<WeatherResponse>
}