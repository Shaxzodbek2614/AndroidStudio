package com.example.intent2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.intent2.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        when(MyData.color){
            1->binding.root.setBackgroundColor(Color.BLACK)
            2->binding.root.setBackgroundColor(Color.RED)
            3->binding.root.setBackgroundColor(Color.YELLOW)
            4->binding.root.setBackgroundColor(Color.GREEN)
            5->binding.root.setBackgroundColor(Color.BLUE)
        }
    }



}