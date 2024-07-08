package com.example.a9weeks.retrofitIf

import com.example.a9weeks.dataClass.AlarmResponse
import com.example.a9weeks.dataClass.BaseData
import com.example.a9weeks.dataClass.GoalDetail
import com.example.a9weeks.dataClass.GoalResult
import com.example.a9weeks.dataClass.HigherGoalResult
import com.example.a9weeks.dataClass.MemoRequestData
import com.example.a9weeks.dataClass.MemoResponseData
import com.example.a9weeks.dataClass.SignInRequestData
import com.example.a9weeks.dataClass.SigninResponseData
import com.example.a9weeks.dataClass.SignupRequestData
import com.example.a9weeks.dataClass.SignupResponseData
import com.example.a9weeks.dataClass.SubGoalCheckResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitIF {

    @POST("/member/singUp")
    fun signUp(
        @Body
        signupRequestData : SignupRequestData
    ) : Call<SignupResponseData>

    @POST("/api/users/login")
    fun signIn(
        @Body
        SiginRequestData: SignInRequestData
    ) : Call<SigninResponseData>

    @GET("/home/main")
    fun getMain(
    ) : Call<BaseData<GoalResult>>

    @GET("/diary/detail/{subGoalId}")
    fun getDiary(
    ) : Call<BaseData<GoalDetail>>

    @POST("/diary/detail/memo")
    fun getMemo(
        @Body
        MemoRequestData: MemoRequestData
    ) : Call<MemoResponseData>

    @POST("/diary/detail/alarm/{diaryId}?day=")
    fun getAlarm(
    ) : Call<AlarmResponse>

    @POST("/diary/check/{subGoalId}")
    fun checkSubGoal(
    ) : Call<SubGoalCheckResponse>

    @GET("/goal/progress")
    fun getPosts() : Call<BaseData<HigherGoalResult>>
}