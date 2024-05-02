package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnlogin).setOnClickListener {
            Toast.makeText(this, findViewById<EditText>(R.id.edtUser).text.toString(),Toast.LENGTH_LONG).show()
        }
    }
}