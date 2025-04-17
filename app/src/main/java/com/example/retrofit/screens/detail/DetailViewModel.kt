package com.example.retrofit.screens.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.RepositoryImpl
import com.example.retrofit.model.WeatherResponse
import kotlinx.coroutines.launch
import com.example.retrofit.BuildConfig

class DetailViewModel: ViewModel() {

    private val repository = RepositoryImpl()
    val weather = MutableLiveData<WeatherResponse>()

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            val response = repository.getWeather(BuildConfig.API_KEY,city)
            if (response.isSuccessful) {
                weather.value = response.body()
            }
        }
    }
}