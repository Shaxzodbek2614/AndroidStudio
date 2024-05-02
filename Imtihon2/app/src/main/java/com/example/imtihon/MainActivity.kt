package com.example.imtihon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.imtihon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.edt.addTextChangedListener {
            val ekran = binding.edt.text.toString()
            binding.txt1.text = ekran
            binding.txt2.text = ekran.reversed()
            binding.txt3.text = "${ekran.substring(ekran.length/2,ekran.length)}${ekran.substring(0,ekran.length/2)}"
            binding.txt4.text = ""
            for (i in 0 until ekran.length){
                for (j in 1..2){
                    binding.txt4.append(ekran[i].toString())
                }
            }
            if (ekran.length>1) {
                binding.txt5.text = "${
                    ekran.subSequence(
                        0,
                        ekran.length / 2+1
                    )
                }${ekran[ekran.length - 1]}${ekran.subSequence(ekran.length - 2, ekran.length - 1)}"
            }
            if (ekran.length>1) {
                binding.txt6.text =
                    "${ekran[1]}${ekran[0]}${ekran.substring(2, ekran.length / 2 + 1)}" +
                            "${ekran[ekran.length - 1]}${
                                ekran.subSequence(
                                    ekran.length - 2,
                                    ekran.length - 1
                                )
                            }"
            }

        }
    }
}