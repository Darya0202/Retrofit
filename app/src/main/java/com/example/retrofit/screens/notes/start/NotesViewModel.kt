package com.example.retrofit.screens.notes.start

import androidx.lifecycle.ViewModel
import com.example.retrofit.core.repository.DatabaseRepository
import com.example.retrofit.data.db.NoteModel
import kotlinx.coroutines.flow.Flow

class NotesViewModel(
    private val repository: DatabaseRepository,
): ViewModel() {

    fun getAllNotes(): Flow<List<NoteModel>> {
        return repository.allNotes
    }
}