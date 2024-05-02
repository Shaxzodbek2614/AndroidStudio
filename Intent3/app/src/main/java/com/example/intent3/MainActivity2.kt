package com.example.intent3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getSerializableExtra("key") as Contact
        binding.txtContact.text = text.toString()
    }
}