package com.example.retrofit.di

import okhttp3.Interceptor

fun createApiKeyInterceptor(apiKey: String): Interceptor {
    return Interceptor { chain ->
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("access_key", apiKey)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }
}