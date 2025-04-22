package com.example.retrofit.screens.notes.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.repository.DatabaseRepository
import com.example.retrofit.data.db.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel(
    private val repository: DatabaseRepository
): ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(noteModel){
                onSuccess()
            }
        }

}