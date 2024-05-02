package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todoapp.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.add.setOnClickListener {
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
            Log.d(TAG, "onCreate: Xatolik")
        }
        binding.showList.setOnClickListener {
            val intent = Intent(this,ToDoList::class.java)
            startActivity(intent)
        }

    }
}