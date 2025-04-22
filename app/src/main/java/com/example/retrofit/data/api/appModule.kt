package com.example.retrofit.data.api

import com.example.retrofit.screens.notes.addnote.AddNoteViewModel
import com.example.retrofit.screens.notes.detail.DetailNoteViewModel
import com.example.retrofit.screens.notes.start.NotesViewModel
import com.example.retrofit.screens.weather.detail.DetailWeatherViewModel
import com.example.retrofit.screens.weather.home.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AddNoteViewModel(get()) }
    viewModel { DetailNoteViewModel(get()) }
    viewModel { NotesViewModel(get()) }

    viewModel { DetailWeatherViewModel(get()) }
    viewModel { WeatherViewModel() }


}