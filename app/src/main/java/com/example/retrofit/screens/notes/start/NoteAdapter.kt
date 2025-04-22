package com.example.retrofit.screens.notes.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.data.db.NoteModel
import com.example.retrofit.databinding.ItemNoteBinding

class NoteAdapter(private val onNoteClick: (NoteModel) -> Unit): RecyclerView.Adapter<NoteAdapter.NoteViewHolder> () {

    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(private val viewBinding: ItemNoteBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(note: NoteModel) {
            viewBinding.itemTitle.text = note.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: NoteModel = listNote[position]

        holder.bind(note)

        holder.itemView.setOnClickListener {
            onNoteClick(note)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }
}