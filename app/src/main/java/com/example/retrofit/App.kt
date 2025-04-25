package com.example.retrofit

import android.app.Application
import com.example.retrofit.data.api.appModule
import com.example.retrofit.data.db.databaseModule
import com.example.retrofit.data.repository.repositoryModule
import com.example.retrofit.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                databaseModule,
                repositoryModule,
                networkModule
            )
        }
    }
}
