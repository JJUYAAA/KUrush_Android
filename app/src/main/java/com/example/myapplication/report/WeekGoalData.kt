package com.example.myapplication.report

data class WeekGoalData(
    val goalName: String,
    val days: List<DayData>
)

data class DayData(
    val day: String,
    var emoji: String = "",
    var memo: String = "",
    var isCompleted: Boolean = false
)