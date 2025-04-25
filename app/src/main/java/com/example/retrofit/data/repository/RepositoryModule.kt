package com.example.retrofit.data.repository

import com.example.retrofit.core.repository.DatabaseRepository
import com.example.retrofit.core.repository.NetworkRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<NetworkRepository> { NetworkRepositoryImpl(get()) }
    single<DatabaseRepository> { DatabaseRepositoryImpl(get()) }
}