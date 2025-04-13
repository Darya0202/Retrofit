package com.example.retrofit.data.api

import com.example.retrofit.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {
    @GET("current")
    suspend fun getWeather(
        @Query("access_key") key: String = "97b9c9aa5c9d3c2ad2e3ee26f1270384",
        @Query("query") city: String
    ): Response<WeatherResponse>
}