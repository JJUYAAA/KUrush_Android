package com.example.myapplication.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemGoalBinding

class GoalAdapter(private val goals: List<String>, private val listener: HomeFragment) : RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    inner class GoalViewHolder(val binding: ItemGoalBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
            binding.tvGoal.setOnClickListener(this)

            // 여기에 아이콘 뷰들의 클릭 이벤트 처리를 추가합니다.
            binding.ivCheckEllipseWhite.setOnClickListener {
                // 아이콘 상태 변경 로직
                binding.ivCheckEllipseWhite.visibility = View.GONE
                binding.ivCheckRed1.visibility = View.GONE
                binding.ivCheckEllipseRed.visibility = View.VISIBLE
                binding.ivCheckWhite1.visibility = View.VISIBLE
            }

        }

        fun bind(goal: String, icon: String) {
            binding.tvGoal.text = goal
            binding.tvIcon.text = icon
        }

        override fun onClick(v: View?) {
            if (v == binding.tvGoal) {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val goal = goals[position]
                    listener.onItemClick(position)
                }
            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val binding = ItemGoalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = goals[position]
        // 아이콘 정보를 가지고 있는 변수를 추가로 전달
        val icon = "💪"  // 예시: 실제로 필요한 정보로 교체
        holder.bind(goal, icon)
    }

    override fun getItemCount() = goals.size


}