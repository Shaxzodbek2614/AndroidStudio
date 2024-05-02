package com.example.imtihon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.telegram)
        txt.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }

    }
}