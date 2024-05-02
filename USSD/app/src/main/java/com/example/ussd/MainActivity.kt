package com.example.ussd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ussd.databinding.ActivityMainBinding
import com.example.ussd.fragments.HomeFragment
import com.example.ussd.fragments.KabinetFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.home.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_navigation_host,HomeFragment())
                .commit()
        }
        binding.profile.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://beeline.uz/uz/Account/Login"))
            startActivity(intent)
        }
        binding.balans.setOnClickListener {
            var number = "*102#"
            number = number.replace("*", Uri.encode("*")).replace("#", Uri.encode("#"))
            val mIntent = Intent(Intent.ACTION_CALL)
            val data = Uri.parse("tel:$number")
            mIntent.setData(data)
            startActivity(mIntent)
        }
        binding.operator.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.my_navigation_host,KabinetFragment())
                .commit()
        }
    }

}