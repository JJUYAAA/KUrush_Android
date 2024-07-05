package com.example.myapplication.goal

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNewGoalBinding
import java.util.Calendar

class NewGoalFragment : Fragment() {

    private lateinit var binding: FragmentNewGoalBinding
    private var routineCount = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewGoalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
        setupDatePickers()
        setupEmojiPicker(binding.flRoutine.ivSelectEmoji, binding.flRoutine.tvSelectedEmoji)
    }

    private fun setupListeners() {
        binding.ivPrevious.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.ivAddRoutineBox.setOnClickListener {
            addNewRoutine()
        }
    }

    private fun setupDatePickers() {
        binding.ivCalendarStart.setOnClickListener { showDatePicker(true) }
        binding.ivCalendarEnd.setOnClickListener { showDatePicker(false) }
    }

    private fun showDatePicker(isStartDate: Boolean) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
            if (isStartDate) {
                binding.etStartDate.setText(selectedDate)
            } else {
                binding.etEndDate.setText(selectedDate)
            }
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun setupEmojiPicker(emojiSelectView: View, emojiTextView: TextView) {
        emojiSelectView.setOnClickListener {
            showEmojiPickerDialog(emojiTextView)
        }
    }

    private fun showEmojiPickerDialog(emojiTextView: TextView) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_emoji_picker, null)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        dialogView.findViewById<GridLayout>(R.id.gridLayout).apply {
            for (i in 0 until childCount) {
                getChildAt(i).setOnClickListener { view ->
                    val selectedEmoji = (view as TextView).text
                    emojiTextView.text = selectedEmoji
                    dialog.dismiss()
                }
            }
        }

        dialog.show()
    }

    private fun addNewRoutine() {
        val newRoutineView = layoutInflater.inflate(R.layout.layout_routine_item, null)
        binding.llRoutinesContainer.addView(newRoutineView)

        // 새로 추가된 루틴의 이모지 선택기 설정
        setupEmojiPicker(
            newRoutineView.findViewById(R.id.iv_select_emoji),
            newRoutineView.findViewById(R.id.tv_selected_emoji)
        )

        routineCount++
        updateAddRoutineBoxPosition()
    }

    private fun updateAddRoutineBoxPosition() {
        val params = binding.ivAddRoutineBox.layoutParams as ViewGroup.MarginLayoutParams
        params.topMargin = resources.getDimensionPixelSize(R.dimen.routine_item_margin_top)
        binding.ivAddRoutineBox.layoutParams = params
    }
}