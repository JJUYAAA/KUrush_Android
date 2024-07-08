package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a9weeks.dataClass.BaseData
import com.example.a9weeks.dataClass.SignInRequestData
import com.example.a9weeks.dataClass.SigninResponseData
import com.example.a9weeks.retrofitIf.RetrofitIF
import com.example.myapplication.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_login)

        val retrofit = RetrofitService.retrofit
        val service = retrofit.create(RetrofitIF :: class.java)

        binding.tvJoin.setOnClickListener{
            val nextIntent = Intent(this, JoinActivity::class.java)
            startActivity(nextIntent)
        }

        binding.flLogin.setOnClickListener {
            val userId = binding.etId.text.toString()
            val password = binding.etPw.text.toString()

            val intent = Intent(this, MainActivity :: class.java)


            service.signIn(SignInRequestData(userId, password)).enqueue(
                object : Callback<SigninResponseData> {
                    override fun onResponse(
                        call: Call<SigninResponseData>,
                        response: Response<SigninResponseData>
                    ) {
                        if(response.isSuccessful){
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                        else{

                        }
                    }
                    override fun onFailure(call: Call<SigninResponseData>, t: Throwable) {

                    }

                }
            )

        }

    }
}


