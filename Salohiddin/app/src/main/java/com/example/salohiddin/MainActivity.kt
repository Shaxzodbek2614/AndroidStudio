package com.example.salohiddin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.salohiddin.adapter.ModelAdapter
import com.example.salohiddin.databinding.ActivityMainBinding
import com.example.salohiddin.model.Model

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<Model>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        val modelAdapter = ModelAdapter(this,list)
        binding.rv.adapter = modelAdapter
    }
    fun loadData(){
        list = ArrayList()
        for (i in 1..20){
            list.add(Model("Shaxzodbek $i",21))
            list.add(Model("Sherzodbek $i",21))
        }
    }
}