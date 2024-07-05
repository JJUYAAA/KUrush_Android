package com.example.myapplication.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentReportWeeklyBinding

class ReportWeeklyFragment : Fragment() {

    private lateinit var binding: FragmentReportWeeklyBinding
    private lateinit var weeklyAdapter: ReportWeeklyAdapter
    private val weeklyItems = ArrayList<WeekGoalData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReportWeeklyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWeeklyItems()
        setupRecyclerView()
    }

    private fun initWeeklyItems() {
        val days = listOf("월", "화", "수", "목", "금", "토", "일")

        // 윗몸 일으키기 목표에 대한 DayData 생성
        val sitUpDays = days.map { day ->
            when (day) {
                "월", "수", "금" -> DayData(day, "💪", "30개", true)
                else -> DayData(day)
            }
        }
        weeklyItems.add(WeekGoalData("윗몸 일으키기", sitUpDays))

        // 독서하기 목표에 대한 DayData 생성
        val readingDays = days.map { day ->
            when (day) {
                "화", "목", "토" -> DayData(day, "📚", "30분", true)
                "일" -> DayData(day, "📚", "1시간", true)
                else -> DayData(day)
            }
        }
        weeklyItems.add(WeekGoalData("독서하기", readingDays))

        // 필요한 만큼 WeekGoalData 추가
    }

    private fun setupRecyclerView() {
        weeklyAdapter = ReportWeeklyAdapter(weeklyItems)
        binding.rvReportWeek.apply {
            adapter = weeklyAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}