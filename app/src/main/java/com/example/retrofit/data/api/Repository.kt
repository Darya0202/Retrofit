package com.example.retrofit.data.api

import com.example.retrofit.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {
    @GET("current")
    suspend fun getWeather(
        @Query("access_key") key: String,
        @Query("query") city: String
    ): Response<WeatherResponse>
}