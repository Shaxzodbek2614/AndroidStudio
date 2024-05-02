package com.example.mohirdevtimepickerdialog

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mohirdevtimepickerdialog.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val calendar = Calendar.getInstance()
        var soat = calendar.get(Calendar.HOUR)
        var minute1 = calendar.get(Calendar.MINUTE)
        binding.btnShow.setOnClickListener {
            val timePickerDialog = TimePickerDialog(this,
                { _, hourOfDay, minute ->
                    binding.txtShow.text = "$hourOfDay:$minute"
                    soat = hourOfDay
                    minute1 = minute
                },
                soat,
                minute1,
                true)

            timePickerDialog.show()


        }
    }
}