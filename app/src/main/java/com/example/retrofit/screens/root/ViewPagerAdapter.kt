package com.example.retrofit.screens.root

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.retrofit.screens.notes.start.NotesFragment
import com.example.retrofit.screens.weather.home.WeatherFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> WeatherFragment()
            else -> NotesFragment()
        }
    }
}