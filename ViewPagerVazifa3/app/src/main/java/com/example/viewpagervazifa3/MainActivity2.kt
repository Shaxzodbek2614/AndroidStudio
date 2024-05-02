package com.example.viewpagervazifa3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpagervazifa3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            finish()
        }
    }
}