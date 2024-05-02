package com.example.mohirdevdiffutil

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mohirdevdiffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var myListAdapter: MyListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        myListAdapter = MyListAdapter()

        binding.swipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed(kotlinx.coroutines.Runnable {
                myListAdapter.submitList(getItem())
                binding.swipeRefreshLayout.isRefreshing = false
            },3000)
        }

        binding.swipeRefreshLayout.setColorSchemeColors(
            Color.RED,
            Color.GRAY,
            Color.BLUE
        )

        binding.rv.apply {
            adapter = myListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }



        myListAdapter.submitList(getItem())



    }
    fun getItem():List<String>{
        val list = mutableListOf<String>()
        for (i in 1..100){
            list.add("Title $i")
        }

        return list
    }
}