package com.example.myapplication.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentReportMonthlyBinding


class ReportMonthlyFragment : Fragment() {

    lateinit var binding: FragmentReportMonthlyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReportMonthlyBinding.inflate(inflater, container, false)

        return binding.root
    }




}