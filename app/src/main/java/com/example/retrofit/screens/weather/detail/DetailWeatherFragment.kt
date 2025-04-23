package com.example.retrofit.screens.weather.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentDetailWeatherBinding

class DetailWeatherFragment : Fragment() {

    private var _binding: FragmentDetailWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailWeatherBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = arguments?.getString("city") ?: return
        val viewModel = ViewModelProvider(this)[DetailWeatherViewModel::class.java]
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
            findNavController().navigate(R.id.action_detailWeatherFragment_to_weatherFragment)
        }
    }
}