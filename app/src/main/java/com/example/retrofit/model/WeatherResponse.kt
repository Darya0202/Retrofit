package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val location: WeatherLocation,
    val current: WeatherCurrent
)

data class WeatherLocation(
    val name: String,
    val region: String
)

data class WeatherCurrent(
    val temperature: Int,
    @SerializedName("weather_descriptions") val weatherDescriptions: List<String>,
    @SerializedName("weather_icons") val weatherIcons: List<String>
)