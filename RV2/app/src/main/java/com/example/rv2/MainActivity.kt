package com.example.rv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rv2.adapter.PredmentAdapter
import com.example.rv2.databinding.ActivityMainBinding
import com.example.rv2.utils.MyData

class MainActivity : AppCompatActivity() {
    private val binding by lazy {   ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyData.addPredment()
        val predmentAdapter = PredmentAdapter(this,MyData.list)
        binding.rv.adapter = predmentAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        MyData.list.clear()
    }
}