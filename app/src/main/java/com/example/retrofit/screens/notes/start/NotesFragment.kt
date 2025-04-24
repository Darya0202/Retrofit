package com.example.retrofit.screens.notes.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.data.db.NoteModel
import com.example.retrofit.databinding.FragmentNotesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: NotesViewModel by viewModel()

        val adapter = NoteAdapter{ note: NoteModel ->
            val bundle = Bundle().apply {
                putSerializable("note", note)
            }
            findNavController().navigate(R.id.action_to_detailNoteFragment, bundle)
        }
        binding.rvNotes.adapter = adapter

        viewModel.getAllNotes().observe(viewLifecycleOwner) { ListNotes ->
            adapter.setList(ListNotes.asReversed())
        }

        binding.btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_to_addNoteFragment)
        }
    }
}