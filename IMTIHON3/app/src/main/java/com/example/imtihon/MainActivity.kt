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
            binding.txt3.text = "${ekran.substring(ekran.length / 2, ekran.length)}${
                ekran.substring(
                    0,
                    ekran.length / 2
                )
            }"
            binding.txt4.text=""
            for (element in ekran) {
                for (j in 1..2) {
                    binding.txt4.append(element.toString())
                }
            }

            val count = ekran.length
            if (count > 1) {
                binding.txt5.text = "${ekran.substring(0, count - 2)}${ekran[count - 1]}${
                    ekran.substring(
                        count - 2,
                        count-1
                    )
                }"
            }else if (count==1){
                binding.txt5.text = ekran[0].toString()
            }else binding.txt5.text = ""
            if (count>3) {
                binding.txt6.text = "${ekran[1]}${ekran[0]}${
                    ekran.substring(
                        2,
                        count - 2
                    )
                }${ekran[count - 1]}${ekran.substring(count - 2, count - 1)}"
            }else binding.txt6.text = ""
        }
    }
}