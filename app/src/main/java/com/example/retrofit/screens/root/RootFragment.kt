package com.example.retrofit.screens.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentNotesBinding
import com.example.retrofit.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator

class RootFragment : Fragment() {
    private var _binding: FragmentRootBinding? = null
    private val binding get() = _binding!!

    private var ctx:Context ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRootBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tabLayout.tabIconTint = null
        binding.viewPager.adapter = ViewPagerAdapter(ctx as FragmentActivity)

        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, position ->
            when(position){
                0 -> {
                    tab.setIcon(R.drawable.weather_icon)
                }
                1 -> {
                    tab.setIcon(R.drawable.note_icon)
                }
            }
        }.attach()
    }

}