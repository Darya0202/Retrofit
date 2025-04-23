package com.example.retrofit.screens.notes.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.repository.DatabaseRepository
import com.example.retrofit.data.db.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailNoteViewModel(
    val repository: DatabaseRepository
): ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(noteModel){
                onSuccess()
            }
        }
}