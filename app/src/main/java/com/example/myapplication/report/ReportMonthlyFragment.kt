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
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ReportMonthlyFragment : Fragment(R.layout.fragment_report_monthly) {

    lateinit var binding: FragmentReportMonthlyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarView = view.findViewById<CustomCalendarView>(R.id.customCalendarView)
        val weeklyGraph = view.findViewById<WeeklyProgressGraph>(R.id.weeklyProgressGraph)
        val monthYearText = view.findViewById<TextView>(R.id.monthYearText)

        // Set current month
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        calendarView.setMonth(year, month)

        // Update month year text
        val dateFormat = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
        monthYearText.text = dateFormat.format(calendar.time)

        // Example data for daily progress
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val dailyProgress = ArrayList<Float>()
        for (i in 1..daysInMonth) {
            dailyProgress.add((0..100).random().toFloat())
        }
        calendarView.setProgressList(dailyProgress)

        // Example data for weekly progress
        val weeklyProgress = arrayListOf(70f, 75f, 55f, 85f)
        weeklyGraph.setWeeklyProgress(weeklyProgress)
    }
}