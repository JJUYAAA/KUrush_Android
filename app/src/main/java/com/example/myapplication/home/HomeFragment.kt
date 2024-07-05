package com.example.myapplication.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.FirstGoalFragment
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomeFragment : Fragment(), GoalAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var goalsAdapter: GoalAdapter
    private val goals = listOf("Goal 1", "Goal 2", "Goal 3") // Example goals

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // RecyclerView 설정
        goalsAdapter = GoalAdapter(goals, this)
        binding.rvGoals.layoutManager = LinearLayoutManager(context)
        binding.rvGoals.adapter = goalsAdapter

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

    override fun onItemClick(position: Int) {
        val fragment = FirstGoalFragment()
        val bundle = Bundle()
        bundle.putString("goal", position.toString())
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.main_frm, fragment)
            .addToBackStack(null)
            .commit()
    }
}