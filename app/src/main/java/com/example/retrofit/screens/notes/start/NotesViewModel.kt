package com.example.retrofit.screens.notes.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.core.repository.DatabaseRepository
import com.example.retrofit.data.db.NoteModel


class NotesViewModel(
    private val repository: DatabaseRepository,
): ViewModel() {

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return repository.allNotes
    }

}