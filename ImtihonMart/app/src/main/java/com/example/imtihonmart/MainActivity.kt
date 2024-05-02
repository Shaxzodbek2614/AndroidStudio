package com.example.imtihonmart

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.imtihonmart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var yuz = 0
        var elik = 0
        var on = 0
        var besh = 0
        var ming = 0
        var a = false
        binding.yuzming.visibility = View.GONE
        binding.elikming.visibility = View.GONE
        binding.ongming.visibility = View.GONE
        binding.beshming.visibility = View.GONE
        binding.mingsom.visibility = View.GONE

        binding.btnYechish.setOnClickListener {
            hideKeyboard()
            val pul = binding.edtKirit.text.toString().toInt()
            if (pul % 1000 == 0) {
                binding.edtKirit.setBackgroundResource(R.drawable.fon)
                yuz = pul / 100000
                elik = (pul - yuz * 100000) / 50000
                on = (pul - yuz * 100000 - elik * 50000) / 10000
                besh = (pul - yuz * 100000 - elik * 50000 - on * 10000) / 5000
                ming = (pul - yuz * 100000 - elik * 50000 - on * 10000 - besh * 5000) / 1000
                binding.yuz.text = yuz.toString()
                binding.elik.text = elik.toString()
                binding.on.text = on.toString()
                binding.besh.text = besh.toString()
                binding.ming.text = ming.toString()
                if (yuz==0) binding.yuzming.visibility = View.GONE
                else {
                    binding.yuzming.visibility = View.VISIBLE
                    animation(binding.yuzming)
                }
                if (elik==0) binding.elikming.visibility = View.GONE
                else {
                    binding.elikming.visibility = View.VISIBLE
                    animation(binding.elikming)
                }
                if (on==0) binding.ongming.visibility = View.GONE
                else {
                    binding.ongming.visibility = View.VISIBLE
                    animation(binding.ongming)
                }
                if (besh==0) binding.beshming.visibility = View.GONE
                else {
                    binding.beshming.visibility = View.VISIBLE
                    animation(binding.beshming)
                }
                if (ming==0) binding.mingsom.visibility = View.GONE
                else {
                    binding.mingsom.visibility = View.VISIBLE
                    animation(binding.mingsom)
                }
            } else {
                binding.edtKirit.setBackgroundResource(R.drawable.fon2)
                binding.yuzming.visibility = View.GONE
                binding.elikming.visibility = View.GONE
                binding.ongming.visibility = View.GONE
                binding.beshming.visibility = View.GONE
                binding.mingsom.visibility = View.GONE
                Toast.makeText(this, "Noto'g'ri qiymat kiritildi", Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
    fun animation(view: View){
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        view.startAnimation(animation)
    }
}