package com.example.retrofit.screens.weather.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.model.WeatherResponse
import com.example.retrofit.core.repository.NetworkRepository
import kotlinx.coroutines.launch

class DetailWeatherViewModel(
    val repository: NetworkRepository
): ViewModel() {

    val weather = MutableLiveData<WeatherResponse>()

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            val response = repository.getWeather(city)
            if (response.isSuccessful) {
                Log.d("API_RESPONSE", response.body().toString())
                weather.value = response.body()
            } else Log.e("API_ERROR", "Ошибка: ${response.code()} — ${response.message()}")
        }
    }
}