package com.example.myapplication.report

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.example.myapplication.R

class WeeklyProgressGraph @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val weeklyProgress = ArrayList<Float>()
    private var progressTextSize = 40f
    private var weekTextSize = 30f

    init {
        context.withStyledAttributes(attrs, R.styleable.WeeklyProgressGraph) {
            progressTextSize = getDimension(R.styleable.WeeklyProgressGraph_progressTextSize, progressTextSize)
            weekTextSize = getDimension(R.styleable.WeeklyProgressGraph_weekTextSize, weekTextSize)
        }
    }

    fun setWeeklyProgress(progress: ArrayList<Float>) {
        weeklyProgress.clear()
        weeklyProgress.addAll(progress)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (weeklyProgress.isEmpty()) return

        val barWidth = width / (weeklyProgress.size * 2f)
        val maxProgress = weeklyProgress.maxOrNull() ?: 100f

        for ((index, progress) in weeklyProgress.withIndex()) {
            val left = index * barWidth * 2
            val top = height * (1 - progress / maxProgress)
            val right = left + barWidth
            val bottom = height.toFloat()

            paint.color = getColorForProgress(progress)
            canvas.drawRoundRect(left, top, right, bottom, 20f, 20f, paint)

            // Draw progress text
            paint.color = Color.rgb(238, 108, 108)
            paint.textSize = progressTextSize
            paint.textAlign = Paint.Align.CENTER
            paint.typeface = Typeface.DEFAULT_BOLD
            val progressText = "${progress.toInt()}%"
            val textX = left + barWidth / 2
            val textY = top - 10
            canvas.drawText(progressText, textX, textY, paint)

            // Draw week number
            paint.color = Color.DKGRAY
            paint.textSize = weekTextSize
            val weekText = "${index + 1}주차"
            val weekTextY = height - 10f
            canvas.drawText(weekText, textX, weekTextY, paint)
        }
    }

    private fun getColorForProgress(progress: Float): Int {
        // Convert progress to a shade of red
        val alpha = (progress / 100 * 255).toInt()
        return Color.argb(alpha, 238, 108, 108)
    }
}

