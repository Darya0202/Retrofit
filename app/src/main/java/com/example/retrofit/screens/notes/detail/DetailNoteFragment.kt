package com.example.retrofit.screens.notes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.data.db.NoteModel
import com.example.retrofit.databinding.FragmentDetailNoteBinding
import com.example.retrofit.screens.root.RootFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailNoteFragment : Fragment() {

    private var _binding: FragmentDetailNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: DetailNoteViewModel by viewModel()

        val currentNote: NoteModel = arguments?.getSerializable("note") as? NoteModel
            ?: throw IllegalArgumentException("Note is missing")

        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescDetail.text = currentNote.description

        val bundle = Bundle().apply {
            putInt(RootFragment.ARG_START_TAB, RootFragment.TAB_NOTES)
        }

        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentNote){
                requireActivity().runOnUiThread {
                    findNavController().navigate(R.id.action_detailNoteFragment_to_rootFragment, bundle)
                }
            }
        }

        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.action_detailNoteFragment_to_rootFragment, bundle)
        }
    }
}