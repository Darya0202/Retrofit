package com.example.retrofit.model

data class Current(
    val temperature: Int,
    val weatherDescriptions: List<String>,
    val weatherIcons: List<String>,
)