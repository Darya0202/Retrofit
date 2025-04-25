package com.example.retrofit.screens.weather.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.model.WeatherResponse
import com.example.retrofit.core.repository.NetworkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailWeatherViewModel(
    private val repository: NetworkRepository
): ViewModel() {

    private val _weather = MutableStateFlow<WeatherResponse?>(null)
    val weather: StateFlow<WeatherResponse?> = _weather

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            val response = repository.getWeather(city)
            if (response.isSuccessful) {
                _weather.value = response.body()
            }
        }
    }
}