package com.example.myapplication.goal

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.myapplication.R

class CustomProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val progressBar: ProgressBar
    private val percentText: TextView
    private val fullColorDrawable: GradientDrawable
    private val gradientDrawable: Drawable?

    init {
        val view = inflate(context, R.layout.custom_progress_bar, this)
        progressBar = view.findViewById(R.id.progressBar)
        percentText = view.findViewById(R.id.percentText)

        progressBar.max = 100
        setProgress(0)

        fullColorDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(Color.parseColor("#EE6C6C"))
            cornerRadius = context.resources.getDimension(R.dimen.progress_corner_radius)
        }

        gradientDrawable = ResourcesCompat.getDrawable(resources, R.drawable.custom_progress, null)
    }

    fun setProgress(progress: Int) {
        progressBar.progress = progress
        percentText.text = "$progress%"
        updateTextPosition()

        progressBar.progressDrawable = if (progress == 100) fullColorDrawable else gradientDrawable
    }

    private fun updateTextPosition() {
        val progressWidth = progressBar.width * progressBar.progress / progressBar.max
        percentText.x = (progressWidth - percentText.width / 2).toFloat() - 40
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        updateTextPosition()
    }
}