package com.example.myapplication.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.FirstGoalFragment
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.R


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ivCheckEllipseWhite.setOnClickListener {
            binding.ivCheckEllipseWhite.visibility =View.GONE
            binding.ivCheckRed1.visibility = View.GONE
            binding.ivCheckEllipseRed.visibility = View.VISIBLE
            binding.ivCheckWhite1.visibility = View.VISIBLE

        }
        binding.ivCheckEllipseWhite2.setOnClickListener{
            binding.ivCheckEllipseWhite2.visibility = View.GONE
            binding.ivCheckRed.visibility = View.GONE
            binding.ivCheckEllipseRed2.visibility = View.VISIBLE
            binding.ivCheckWhite.visibility = View.VISIBLE
        }

        val transaction = parentFragmentManager.beginTransaction()
        binding.flHomeGoal1.setOnClickListener{
            transaction.replace(R.id.main_frm, FirstGoalFragment()).commit()
        }
        binding.flHomeGoal2.setOnClickListener {
            binding.flHomeGoal2.setOnClickListener{
                transaction.replace(R.id.main_frm, FirstGoalFragment()).commit()
            }
        }

        return binding.root
    }


}