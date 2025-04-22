package com.example.retrofit.data.db

import androidx.room.Room
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            NoteDatabase::class.java,
            "db"
        ).build()
    }
    single { get<NoteDatabase>().getNoteDao() }
}