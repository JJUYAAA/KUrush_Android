package com.example.myapplication

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.goal.GoalFragment
import com.example.myapplication.history.HistoryFragment
import com.example.myapplication.home.HomeFragment
import com.example.myapplication.report.ReportFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()
        binding.mainBnv.selectedItemId = R.id.HomeFragment


        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.HomeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.GoalFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, GoalFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.ReportFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ReportFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }


                R.id.HistoryFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HistoryFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

            }
            false
        }
        binding.mainBnv.itemIconTintList = null


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragment = supportFragmentManager.findFragmentById(R.id.main_frm)
                if (fragment is HomeFragment) {
                    finish()
                } else {
                    binding.mainBnv.selectedItemId = R.id.HomeFragment
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

    }

}