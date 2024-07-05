package com.example.myapplication.report

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.DayItemBinding

class ReportDayAdapter (private var items: List<DayData>) : RecyclerView.Adapter<ReportDayAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DayItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DayData) {
            binding.tvDay.text = item.day
            binding.ivEmoji.text = item.emoji
            binding.tvEditMemo.text = item.memo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportDayAdapter.ViewHolder {
        val binding = DayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportDayAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<DayData>) {
        items = newItems
        notifyDataSetChanged()
    }

}