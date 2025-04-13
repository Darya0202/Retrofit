package com.example.retrofit.model

data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)