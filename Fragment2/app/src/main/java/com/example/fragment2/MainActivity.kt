package com.example.fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fragment2.databinding.ActivityMainBinding
import kotlin.math.log

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ")
        val fragmentShukur = FragmentShukur().apply {
            arguments = Bundle().apply {
                putString("key","Assalomu alaykum")
            }
        }
        val yusufFragment = YusufFragment().apply {
            arguments = Bundle().apply {
                putString("key","Va alaykum asslom")
            }
        }
        var a = true


        binding.apply {
            btnAdd.setOnClickListener {
                if (a) {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.container, fragmentShukur).commit()
                    a = false
                }
            }
            btnDelete.setOnClickListener {
                if (!a){
                supportFragmentManager.beginTransaction().
                remove(fragmentShukur).commit()
                    a=true
                }else supportFragmentManager.beginTransaction().remove(yusufFragment).commit()
            }
            btnReplace.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .addToBackStack("salom")
                    .replace(R.id.container,yusufFragment).commit()
            }
            btnHide.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .hide(fragmentShukur).commit()
            }
            btnShow.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .show(fragmentShukur).commit()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }
}