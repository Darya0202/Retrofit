package com.example.retrofit.model

data class Current(
    val airQuality: AirQuality,
    val astro: Astro,
    val cloudcover: Int,
    val feelslike: Int,
    val humidity: Int,
    val isDay: String,
    val observationTime: String,
    val precip: Int,
    val pressure: Int,
    val temperature: Int,
    val uvIndex: Int,
    val visibility: Int,
    val weatherCode: Int,
    val weatherDescriptions: List<String>,
    val weatherIcons: List<String>,
    val windDegree: Int,
    val windDir: String,
    val windSpeed: Int
)