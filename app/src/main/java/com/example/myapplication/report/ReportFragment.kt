package com.example.myapplication.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentReportBinding


class ReportFragment : Fragment() {

    lateinit var binding: FragmentReportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReportBinding.inflate(inflater, container, false)


        return binding.root
    }

}