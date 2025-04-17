package com.example.retrofit.screens.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofit.BuildConfig
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentDetailBinding
import com.example.retrofit.model.WeatherResponse
import com.example.retrofit.screens.home.HomeViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = arguments?.getString("city") ?: return
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        viewModel.fetchWeather(city)
        binding.city.text = city

        viewModel.weather.observe(viewLifecycleOwner) { weather ->
            binding.weatherDescriptions.text = weather.current?.weatherDescriptions?.firstOrNull() ?: "No description"
            binding.degrees.text = getString(R.string.temperature, weather.current?.temperature ?: 0)
            Glide.with(binding.image.context)
                .load(weather.current?.weatherIcons?.firstOrNull())
                .into(binding.image)
        }

        binding.buttonExit.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

}