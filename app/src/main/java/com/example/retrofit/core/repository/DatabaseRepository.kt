package com.example.retrofit.core.repository

import com.example.retrofit.data.db.NoteModel
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    val allNotes: Flow<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)

    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
}