package com.example.retrofit.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.RepositoryImpl
import com.example.retrofit.model.WeatherResponse
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val cityList = listOf(
        "Moscow",
        "Volgograd",
        "Saint Petersburg",
        "Kazan",
        "Tokyo",
        "Madrid",
        "Istanbul",
        "Beijing",
        "Seoul",
        "New York",
        "Toronto",
        "London",
        "Mumbai",
        "Paris",
        "Rome"
    )
}