package com.example.retrofit.data.api

import com.example.retrofit.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val apiKey = BuildConfig.API_KEY

    private val client = OkHttpClient.Builder()
        .addInterceptor(createApiKeyInterceptor(apiKey))
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.weatherstack.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: Repository by lazy {
        retrofit.create(Repository::class.java)
    }
}

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
