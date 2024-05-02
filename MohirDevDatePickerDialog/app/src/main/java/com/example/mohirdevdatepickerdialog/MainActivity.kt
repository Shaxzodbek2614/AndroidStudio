package com.example.mohirdevdatepickerdialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mohirdevdatepickerdialog.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(this,0,
                { _, year, month, dayOfMonth ->
                    binding.txtDate.text = "$dayOfMonth/${month+1}/$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
            calendar.set(Calendar.DAY_OF_MONTH,20)
            datePickerDialog.datePicker.maxDate = calendar.timeInMillis
            calendar.set(Calendar.DAY_OF_MONTH,1)
            datePickerDialog.datePicker.minDate = calendar.timeInMillis

            datePickerDialog.show()
            datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).text = "Tanlash"

        }
    }
}