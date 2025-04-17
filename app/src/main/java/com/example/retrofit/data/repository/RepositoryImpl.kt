package com.example.retrofit.data.repository

import com.example.retrofit.data.api.Repository
import com.example.retrofit.data.api.RetrofitInstance
import com.example.retrofit.model.WeatherResponse
import com.example.retrofit.BuildConfig
import retrofit2.Response

class RepositoryImpl: Repository {
    override suspend fun getWeather(key: String, city: String): Response<WeatherResponse> {
        return RetrofitInstance.api.getWeather(BuildConfig.API_KEY, city = city)
    }
}