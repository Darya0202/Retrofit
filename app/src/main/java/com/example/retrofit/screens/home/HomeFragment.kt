package com.example.retrofit.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentHomeBinding
import com.example.retrofit.screens.detail.DetailFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val adapter = HomeAdapter { city ->
            val bundle = Bundle().apply {
                putString("city", city)
            }

            findNavController().navigate(
                R.id.action_homeFragment_to_detailFragment,
                Bundle().apply { putString("city", city) }
            )
        }
        adapter.setCityList(viewModel.cityList)
        binding.rvHome.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}