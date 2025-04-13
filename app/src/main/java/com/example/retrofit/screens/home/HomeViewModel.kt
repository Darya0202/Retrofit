package com.example.retrofit.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.RepositoryImpl
import com.example.retrofit.model.WeatherResponse
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    var repo = RepositoryImpl()
    val myList: MutableLiveData<ArrayList<WeatherResponse>> = MutableLiveData()

    fun getWeather(){
        viewModelScope.launch {
            myList.value = repo.getWeather()
        }
    }

}