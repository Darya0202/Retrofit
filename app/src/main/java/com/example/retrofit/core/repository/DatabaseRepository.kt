package com.example.retrofit.core.repository

import androidx.lifecycle.LiveData
import com.example.retrofit.data.db.NoteModel

interface DatabaseRepository {

    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)

    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
}