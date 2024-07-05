package com.example.myapplication.goal

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNewGoalBinding
import java.util.Calendar


class NewGoalFragment : Fragment() {

    private lateinit var binding: FragmentNewGoalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewGoalBinding.inflate(inflater, container, false)

        binding.ivPrevious.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDatePickers()
        setupEmojiPicker()
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

    private fun setupEmojiPicker() {
        binding.ivSelectEmoji.setOnClickListener {
            showEmojiPickerDialog()
            binding.tvSelectedEmoji.text = ""
        }
    }

    private fun showEmojiPickerDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_emoji_picker, null)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        dialogView.findViewById<GridLayout>(R.id.gridLayout).apply {
            for (i in 0 until childCount) {
                getChildAt(i).setOnClickListener { view ->
                    val selectedEmoji = (view as TextView).text
                    binding.tvSelectedEmoji.text = selectedEmoji
                    dialog.dismiss()
                }
            }
        }

        dialog.show()
    }
}