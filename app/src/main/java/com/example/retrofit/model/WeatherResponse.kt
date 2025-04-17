package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val current: WeatherCurrent? = null
)

data class WeatherCurrent(
    val temperature: Int? = null,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>? = null,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>? = null
)
