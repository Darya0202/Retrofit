package com.example.retrofit.data.db

import android.content.Context
import androidx.room.Room
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(get()) }
    single { get<NoteDatabase>().getNoteDao() }
}

private fun provideDatabase(context: Context): NoteDatabase {
    return Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "db"
    ).build()
}
