package com.example.myapplication.goal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentGoalBinding
import com.google.android.material.tabs.TabLayoutMediator


class GoalFragment : Fragment() {

    lateinit var binding: FragmentGoalBinding
    private val tapList = arrayListOf("진행중인 목표", "완료한 목표")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoalBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {
        binding.vpMain.adapter = GoalTabLayoutVPAdapter(requireActivity())
        TabLayoutMediator(binding.tlMain, binding.vpMain){ tab, position ->
            tab.text = tapList[position]
        }.attach()
    }

}