package com.example.retrofit.data.repository

import com.example.retrofit.data.api.Repository
import com.example.retrofit.data.api.RetrofitInstance
import com.example.retrofit.model.WeatherResponse
import retrofit2.Response

class RepositoryImpl: Repository {
    override suspend fun getWeather(city: String): Response<WeatherResponse> {
        return RetrofitInstance.api.getWeather(city = city)
    }
}