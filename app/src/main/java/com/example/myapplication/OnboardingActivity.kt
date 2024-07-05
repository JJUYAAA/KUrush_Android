package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingActivity : AppCompatActivity() {
    private val DELAY_MILLIS: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Use a handler to delay the transition
        Handler(Looper.getMainLooper()).postDelayed({
            // Intent to navigate to the next activity
            val intent = Intent(this@OnboardingActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish the current activity
        }, DELAY_MILLIS)
    }
}