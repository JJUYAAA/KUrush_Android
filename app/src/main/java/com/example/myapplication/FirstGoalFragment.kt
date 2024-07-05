package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentFirstGoalBinding
import com.example.myapplication.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class FirstGoalFragment : Fragment() {
    private lateinit var binding : FragmentFirstGoalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstGoalBinding.inflate(inflater, container, false)
        // 현재 날짜 가져오기
        val calendar = Calendar.getInstance()
        val currentDate = calendar.time

        // 날짜를 특정 형식의 문자열로 변환 (예: 2024년 7월 6일)
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDate)

        // tv_date 텍스트뷰에 날짜 설정
        binding.tvDate.text = formattedDate

        return binding.root
    }


}