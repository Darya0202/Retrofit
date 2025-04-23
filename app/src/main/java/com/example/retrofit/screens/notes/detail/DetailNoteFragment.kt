package com.example.retrofit.screens.notes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.data.db.NoteModel
import com.example.retrofit.databinding.FragmentDetailNoteBinding

class DetailNoteFragment : Fragment() {

    private var _binding: FragmentDetailNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[DetailNoteViewModel::class.java]

        val currentNote: NoteModel = arguments?.getSerializable("note") as? NoteModel
            ?: throw IllegalArgumentException("Note is missing")

        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescDetail.text = currentNote.description

        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentNote){
                requireActivity().runOnUiThread {
                    findNavController().navigate(R.id.action_detailNoteFragment_to_notesFragment)
                }
            }
        }
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.action_detailNoteFragment_to_notesFragment)
        }
    }
}