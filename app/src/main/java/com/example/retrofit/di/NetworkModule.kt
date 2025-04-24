package com.example.retrofit.di

import com.example.retrofit.BuildConfig
import com.example.retrofit.data.api.WeatherApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<Interceptor> { provideApiKeyInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }
}

private fun provideApiKeyInterceptor(): Interceptor {
    return Interceptor { chain ->
        val original = chain.request()
        val originalUrl = original.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("access_key", BuildConfig.API_KEY)
            .build()

        val newRequest = original.newBuilder().url(newUrl).build()
        chain.proceed(newRequest)
    }
}

private fun provideOkHttpClient(apiKeyInterceptor: Interceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.weatherstack.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


