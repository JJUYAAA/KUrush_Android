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
import java.util.*

class CustomCalendarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val progressList = ArrayList<Float>()
    private var currentMonth = Calendar.getInstance()
    private val daysOfWeek = arrayOf("월", "화", "수", "목", "금", "토", "일")

    private var dayOfWeekTextColor = Color.BLACK
    private var dayOfWeekTextSize = 24f
    private var percentTextColor = Color.WHITE
    private var percentTextSize = 20f
    private var progressColor = Color.rgb(255, 99, 71) // Tomato color

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomCalendarView) {
            dayOfWeekTextColor = getColor(R.styleable.CustomCalendarView_dayOfWeekTextColor, dayOfWeekTextColor)
            dayOfWeekTextSize = getDimension(R.styleable.CustomCalendarView_dayOfWeekTextSize, dayOfWeekTextSize)
            percentTextColor = getColor(R.styleable.CustomCalendarView_percentTextColor, percentTextColor)
            percentTextSize = getDimension(R.styleable.CustomCalendarView_percentTextSize, percentTextSize)
            progressColor = getColor(R.styleable.CustomCalendarView_progressColor, progressColor)
        }
    }

    fun setMonth(year: Int, month: Int) {
        currentMonth.set(Calendar.YEAR, year)
        currentMonth.set(Calendar.MONTH, month)
        invalidate()
    }

    fun setProgressList(progress: ArrayList<Float>) {
        progressList.clear()
        progressList.addAll(progress)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val daysInMonth = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
        val cellWidth = width / 7f
        val cellHeight = height / 4f  // 4 rows: 1 for days of week, 3 for dates

        // Draw days of week
        paint.color = dayOfWeekTextColor
        paint.textSize = dayOfWeekTextSize
        paint.textAlign = Paint.Align.CENTER
        for (i in 0..6) {
            canvas.drawText(daysOfWeek[i], cellWidth * i + cellWidth / 2, 40f, paint)
        }

        // Draw progress circles
        val circleRadius = cellWidth * 0.4f
        for (i in 1..daysInMonth) {
            val column = (i - 1) % 7
            val row = (i - 1) / 7

            val centerX = column * cellWidth + cellWidth / 2
            val centerY = (row + 1) * cellHeight + cellHeight / 2

            if (i <= progressList.size) {
                val progress = progressList[i - 1]
                paint.style = Paint.Style.FILL
                paint.color = getColorForProgress(progress)
                canvas.drawCircle(centerX, centerY, circleRadius, paint)

                // Draw progress text
                paint.color = percentTextColor
                paint.textSize = percentTextSize
                paint.textAlign = Paint.Align.CENTER
                paint.typeface = Typeface.DEFAULT_BOLD

                // Calculate y-coordinate for centered text
                val textHeight = paint.descent() - paint.ascent()
                val textOffset = (textHeight / 2) - paint.descent()
                val progressText = "${progress.toInt()}%"
                canvas.drawText(progressText, centerX, centerY + textOffset, paint)
            }
        }
    }

    private fun getColorForProgress(progress: Float): Int {
        val alpha = (progress / 100 * 255).toInt()
        return Color.argb(alpha, Color.red(progressColor), Color.green(progressColor), Color.blue(progressColor))
    }
}
