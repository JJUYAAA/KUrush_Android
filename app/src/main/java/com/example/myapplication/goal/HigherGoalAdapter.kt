package com.example.myapplication.goal

import HigherGoalItem
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.GoalHigherItemBinding

class HigherGoalAdapter(val context: Context, val higherGoals: ArrayList<HigherGoalItem>) : RecyclerView.Adapter<HigherGoalAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: GoalHigherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(higherGoal: HigherGoalItem) {
            binding.tvHigherGoal.text = higherGoal.HigherGoalText

            val lowerGoalAdapter = LowerGoalAdapter(higherGoal.lowerGoals)
            binding.rvLowerGoal.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = lowerGoalAdapter
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GoalHigherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = higherGoals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(higherGoals[position])
    }


}