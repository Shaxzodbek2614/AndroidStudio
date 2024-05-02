package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.todo.adapters.ModelAdapter
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.databinding.ItemParentBinding
import com.example.todo.utils.MyData

class MainActivity : AppCompatActivity() {
    lateinit var modelAdapter: ModelAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MyData.addModel()
        modelAdapter = ModelAdapter(MyData.title,MyData.map)
        binding.rv.setAdapter(modelAdapter)

        binding.rv.setOnChildClickListener { parent, v, groupPosition, childPosition, i2 ->
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("key1",childPosition)
            intent.putExtra("key3",groupPosition)
            intent.putExtra("key2",i2)
            startActivity(intent)
            val item = ItemParentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            item.image.setImageResource(R.drawable.down)
            true
        }
    }



}