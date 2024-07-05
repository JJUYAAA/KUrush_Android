package com.example.myapplication.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentReportBinding
import com.google.android.material.tabs.TabLayoutMediator


class ReportFragment : Fragment() {

    lateinit var binding: FragmentReportBinding
    private val tapList = arrayListOf("주간 보기", "월간 보기", "전체 보기")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReportBinding.inflate(inflater, container, false)

        initView()
        return binding.root
    }

    private fun initView() {
        binding.vpMain.adapter =
            ReportTabLayoutVPAdapter.ReportTabLayoutVPAdapter(requireActivity())
        TabLayoutMediator(binding.tlMain, binding.vpMain){ tab, position ->
            tab.text = tapList[position]
        }.attach()
    }






}