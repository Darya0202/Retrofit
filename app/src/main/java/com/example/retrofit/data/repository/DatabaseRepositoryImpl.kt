package com.example.retrofit.data.repository

import androidx.lifecycle.LiveData
import com.example.retrofit.core.repository.DatabaseRepository
import com.example.retrofit.data.db.NoteDao
import com.example.retrofit.data.db.NoteModel

class DatabaseRepositoryImpl(private val noteDao: NoteDao): DatabaseRepository {

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}