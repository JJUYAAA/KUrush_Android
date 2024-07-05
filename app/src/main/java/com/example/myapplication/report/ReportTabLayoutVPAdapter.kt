package com.example.myapplication.report

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ReportTabLayoutVPAdapter {
    class ReportTabLayoutVPAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> ReportWeeklyFragment()
                1 -> ReportMonthlyFragment()
                else -> ReportAllFragment()
            }
        }

    }
}