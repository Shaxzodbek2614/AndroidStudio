package com.example.vazifa2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txt:TextView
    lateinit var edt:EditText
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.txt)
        edt = findViewById(R.id.edt)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            val matn = edt.text.toString()
            txt.text = matn
        }
    }
}