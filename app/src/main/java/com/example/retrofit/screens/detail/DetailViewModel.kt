package com.example.retrofit.screens.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.RepositoryImpl
import com.example.retrofit.model.WeatherResponse
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val repository = RepositoryImpl()
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