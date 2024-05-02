package com.example.intent3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent3.databinding.ActivityMain2Binding
import com.example.intent3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            val contact = Contact(binding.name.text.toString(),binding.nummber.text.toString().toInt())
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("key",contact)
            startActivity(intent)
        }
    }
}