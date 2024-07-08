package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a9weeks.dataClass.BaseData
import com.example.a9weeks.dataClass.SignupRequestData
import com.example.a9weeks.dataClass.SignupResponseData
import com.example.a9weeks.retrofitIf.RetrofitIF
import com.example.myapplication.databinding.ActivityJoinBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {

    lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val retrofit = RetrofitService.retrofit
        val service = retrofit.create(RetrofitIF::class.java)

        binding.flSignup.setOnClickListener{
            val userId = binding.etId.text.toString()
            val password = binding.etPw.text.toString()
            val intent = Intent(this, LoginActivity::class.java)

            service.signUp(SignupRequestData(userId, password))
                .enqueue(object : Callback<SignupResponseData> {

                    override fun onResponse(
                        call: Call<SignupResponseData>,
                        response: Response<SignupResponseData>
                    ) {
                        if(response.isSuccessful){
                            Log.d("성공", response.body().toString())

                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        } else {
                        }
                    }

                    override fun onFailure(call: Call<SignupResponseData>, t: Throwable) {
                        Log.d("실패", t.message.toString())
                    }

                })
        }
    }
}