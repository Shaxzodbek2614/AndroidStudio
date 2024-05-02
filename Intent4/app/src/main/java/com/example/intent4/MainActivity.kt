package com.example.intent4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.card1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://kun.uz/uz/news/2024/01/31/surxondaryo-viloyati-iibga-yangi-boshliq-tayinlandi")
            startActivity(intent)
        }
        binding.card2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://kun.uz/uz/news/2024/01/31/tashabbusli-budjetda-bir-fuqaro-bir-ovoz-tizimi-joriy-etiladi")
            startActivity(intent)
        }
        binding.card3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://kun.uz/uz/news/2024/01/31/telegramda-zararli-virus-dasturlar-tarqatib-kelgan-18-yoshli-haker-yigit-ushlandi")
            startActivity(intent)
        }
        binding.card4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://kun.uz/uz/news/2024/01/31/qashqadaryoning-togli-qishlogida-qariyb-1-metr-qor-yogdi")
            startActivity(intent)
        }
        binding.card5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://kun.uz/uz/news/2024/01/29/rahbarlar-shahar-piyodalar-uchun-degan-shiorni-ozining-asosiy-tamoyili-qilib-olishi-shart-shavkat-mirziyoyev")
            startActivity(intent)
        }
    }
}