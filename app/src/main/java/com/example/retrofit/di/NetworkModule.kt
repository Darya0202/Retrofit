package com.example.retrofit.di

import com.example.retrofit.BuildConfig
import com.example.retrofit.data.api.WeatherApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Interceptor> {
        Interceptor { chain ->
            val original = chain.request()
            val originalUrl = original.url

            val newUrl = originalUrl.newBuilder()
                .addQueryParameter("access_key", BuildConfig.API_KEY)
                .build()

            val newRequest = original.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.weatherstack.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }
}

