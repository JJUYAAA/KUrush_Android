package com.example.a9weeks.dataClass

import com.google.gson.annotations.SerializedName
import retrofit2.http.Header
import java.sql.Timestamp
import java.time.LocalDateTime

data class BaseData<T> (
    @SerializedName("code")
    val code : Int,
    @SerializedName("status")
    val status : Int,
    @SerializedName("message")
    val message : String,
    @SerializedName("result")
    val result : T
)

data class GoalResult(
    @SerializedName("percent")
    val percent: Int,
    @SerializedName("content")
    val content: List<SubGoal>
)

data class SubGoal(
    @SerializedName("id")
    val id: Int,
    @SerializedName("subGoal")
    val subGoal: String,
    @SerializedName("emoji")
    val emoji: String,
    @SerializedName("isChecked")
    val isChecked: Boolean
)

data class SignupRequestData(
    @SerializedName("id")
    val id : String,
    @SerializedName("password")
    val password : String,
)

data class SignupResponseData(
    @SerializedName("code")
    val code : Int,
    @SerializedName("status")
    val status : Int,
    @SerializedName("message")
    val message : String,
)

data class SignInRequestData(
    @SerializedName("email")
    val userId : String,
    @SerializedName("password")
    val password : String
)

data class SigninResponseData(
    @SerializedName("code")
    val code : Int,
    @SerializedName("status")
    val status : Int,
    @SerializedName("message")
    val message : String,
)

data class GoalDetail(
    @SerializedName("goal")
    val goal: String,
    @SerializedName("subGoal")
    val subGoal: String,
    @SerializedName("emoji")
    val emoji: String,
    @SerializedName("isChecked")
    val isChecked: Boolean,
    @SerializedName("memo")
    val memo: String?,
    @SerializedName("startAt")
    val startAt: String,
    @SerializedName("endAt")
    val endAt: String,
    @SerializedName("alarm")
    val alarm: List<Int>
)

data class MemoRequestData(
    @SerializedName("id")
    val userId : String,
    @SerializedName("password")
    val password : String
)

data class MemoResponseData(
    @SerializedName("code")
    val code : Int,
    @SerializedName("status")
    val status : Int,
    @SerializedName("message")
    val message : String,
)

data class AlarmResponse(
    @SerializedName("code")
    val code : Int,
    @SerializedName("status")
    val status : Int,
    @SerializedName("message")
    val message : String,
)

data class SubGoalCheckResponse(
    @SerializedName("code")
    val code : Int,
    @SerializedName("status")
    val status : Int,
    @SerializedName("message")
    val message : String,
)

data class SubGoalProgressResponse(
    @SerializedName("percent")
    val percent: Int,
)

data class HigherGoalResult(
    @SerializedName("goal")
    val goal: String,
    @SerializedName("content")
    val content: List<LowerGoal>
)

data class LowerGoal(
    @SerializedName("subGoal")
    val subGoal: String,
    @SerializedName("emoji")
    val emoji: String,
    @SerializedName("precent")
    val isChecked: Int
)





