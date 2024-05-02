package com.example.viewpagervazifa2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagervazifa2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<Model>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        val modelAdapter = ModelAdapter(this,list)
        binding.pager.adapter = modelAdapter
        TabLayoutMediator(binding.tablayout,binding.pager){tab,position->
        }.attach()
        binding.tablayout.background = null
        binding.otkazish.setOnClickListener {
            binding.pager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }
        binding.keyingisi.setOnClickListener {
            binding.pager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position==3){
                    binding.keyingisi.visibility = View.INVISIBLE
                    binding.left.visibility = View.INVISIBLE
                }else{
                    binding.keyingisi.visibility = View.VISIBLE
                    binding.left.visibility = View.VISIBLE
                }
            }
        })
    }

    fun loadData(){
        list = ArrayList()
        list.add(Model(R.drawable.page3,"Click va Palmega o'tish xizmati"))
        list.add(Model(R.drawable.page2,"Barcha operatorlar bo'yicha statistika"))
        list.add(Model(R.drawable.page1,"Tariflarni filtrlash"))
        list.add(Model(R.drawable.page4,"Yangi imkonyatlar"))
    }
}