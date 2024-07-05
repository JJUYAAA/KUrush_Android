package com.example.myapplication.goal

import LowerGoalItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.GoalLowerItemBinding

class LowerGoalAdapter(private val lowerGoals: List<LowerGoalItem>) : RecyclerView.Adapter<LowerGoalAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: GoalLowerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lowerGoal: LowerGoalItem) {
            binding.icEmoji.text = lowerGoal.Emoji
            binding.tvEditLowerGoal.text = lowerGoal.LowerGoalText
            binding.customProgressBar.setProgress(lowerGoal.progress)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GoalLowerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = lowerGoals.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lowerGoals[position])
    }


}