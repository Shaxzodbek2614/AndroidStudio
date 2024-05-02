package com.example.viewpagervazifa3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagervazifa3.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<Model>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        val modelAdapter = ModelAdapter(this,list)
        binding.pager.adapter = modelAdapter
        binding.tablayout.background = null
        TabLayoutMediator(binding.tablayout,binding.pager){_,_->}.attach()
        binding.btnName.setOnClickListener {
            binding.pager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position==0){
                    binding.btnName.visibility = View.INVISIBLE
                }else{
                    binding.btnName.visibility = View.VISIBLE
                }
            }
        })
        binding.otish.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun loadData() {
        list = ArrayList()
        list.add(
            Model(
                R.drawable.geoaxborot,
                "Geoaxborot",
                "Geoaxborot moduli orqali siz o'zingizga yaqin bo'lgan migrantlar va boshqa muassasalar haqida ma'lumot olishingiz mumkin"
            )
        )
        list.add(
            Model(
                R.drawable.questions_amico,
                "Huquqiy axborot",
                "Huquqiy axborot moduli orqali siz migratsiya sohasiga oid yangiliklardan, qonunlardan xabardor bo'lishingiz va online konsultatsiya olishingiz mumkin"
            )
        )
        list.add(
            Model(
                R.drawable.tolovlar_xizmati,
                " To'lovlar xizmatlari",
                "To'lov xizmatlari moduli orqali siz masofadan turib turli xil xizmatlarga to'lovlar haqida ma'lumot olishingiz va to'lovlarni amalga oshirishingiz mumkin"
            )
        )
        list.add(
            Model(
                R.drawable.qoshimcha_imkoniyat,
                "Qo'shimcha imkoniyat",
                "Qo'shimcha imkoniyatlar moduli orqali siz interaktiv so'zlashgichlar va lug'atlar yordamida til bilish savodxonligingizni oshirishingiz mumkin"
            )
        )
    }
}