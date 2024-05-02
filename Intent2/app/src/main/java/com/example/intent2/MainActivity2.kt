package com.example.intent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intent2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBlack.setOnClickListener {
            MyData.color=1
            Toast.makeText(this, "O'rnatildi", Toast.LENGTH_SHORT).show()
        }
        binding.btnRed.setOnClickListener {
            MyData.color=2
            Toast.makeText(this, "O'rnatildi", Toast.LENGTH_SHORT).show()
        }
        binding.btnYellow.setOnClickListener {
            MyData.color=3
            Toast.makeText(this, "O'rnatildi", Toast.LENGTH_SHORT).show()
        }
        binding.btnGreen.setOnClickListener {
            MyData.color=4
            Toast.makeText(this, "O'rnatildi", Toast.LENGTH_SHORT).show()
        }
        binding.btnBlue.setOnClickListener {
            MyData.color=5
            Toast.makeText(this, "O'rnatildi", Toast.LENGTH_SHORT).show()
        }
    }
}