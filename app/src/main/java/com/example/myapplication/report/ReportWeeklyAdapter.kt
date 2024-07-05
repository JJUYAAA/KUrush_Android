package com.example.myapplication.report

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.WeekGoalItemBinding

class ReportWeeklyAdapter(private var items: List<WeekGoalData>) : RecyclerView.Adapter<ReportWeeklyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WeekGoalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeekGoalData) {
            binding.tvLowerGoal.text = item.goalName
            // 여기에 ReportDayAdapter 설정 코드 추가
            val dayAdapter = ReportDayAdapter(item.days)
            binding.rvDays.adapter = dayAdapter
            binding.rvDays.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeekGoalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}
