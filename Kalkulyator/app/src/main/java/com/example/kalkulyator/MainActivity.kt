package com.example.kalkulyator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kalkulyator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Formatter.BigDecimalLayoutForm

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txt.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btnNol.setOnClickListener(this)
        binding.btnQoshish.setOnClickListener(this)
        binding.btnAyrish.setOnClickListener(this)
        binding.btnBolish.setOnClickListener(this)
        binding.btnKopaytirish.setOnClickListener(this)
        binding.btnOpen.setOnClickListener(this)
        binding.btnClose.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)
        binding.btnNuqta.setOnClickListener(this)
        binding.btnBacksape.setOnClickListener(this)
        binding.btnTeng.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val id = v?.id
        when(id){
            R.id.btn_nol->{
                emptyAdd()
                binding.txt.append("0")
            }
            R.id.btn_1->{
                emptyAdd()
                binding.txt.append("1")
            }
            R.id.btn_2->{
                emptyAdd()
                binding.txt.append("2")
            }
            R.id.btn_3->{
                emptyAdd()
                binding.txt.append("3")
            }
            R.id.btn_4->{
                emptyAdd()
                binding.txt.append("4")
            }
            R.id.btn_5->{
                emptyAdd()
                binding.txt.append("5")
            }
            R.id.btn_6->{
                emptyAdd()
                binding.txt.append("6")
            }
            R.id.btn_7->{
                emptyAdd()
                binding.txt.append("7")
            }
            R.id.btn_8->{
                emptyAdd()
                binding.txt.append("8")
            }
            R.id.btn_9->{
                emptyAdd()
                binding.txt.append("9")
            }
            R.id.btn_Open->{
                emptyAdd()
                binding.txt.append("(")
            }
            R.id.btn_Close->{
                emptyAdd()
                binding.txt.append(")")
            }
            R.id.btn_qoshish->{
                val text = binding.txt.text.toString()
                if (text!="" && !text.endsWith(".") && !text.endsWith("+") && !text.endsWith("-")
                    && !text.endsWith("*") && !text.endsWith("/")) {
                        binding.txt.append("+")
                    }
            }
            R.id.btn_ayrish->{
                val text = binding.txt.text.toString()
                if (text!="" && !text.endsWith(".") && !text.endsWith("+") && !text.endsWith("-")
                    && !text.endsWith("*") && !text.endsWith("/")) {
                    binding.txt.append("-")
                }
            }
            R.id.btn_kopaytirish->{
                val text = binding.txt.text.toString()
                if (text!="" && !text.endsWith(".") && !text.endsWith("+") && !text.endsWith("-")
                    && !text.endsWith("*") && !text.endsWith("/")) {
                    binding.txt.append("*")
                }
            }
            R.id.btn_bolish->{
                val text = binding.txt.text.toString()
                if (text!="" && !text.endsWith(".") && !text.endsWith("+") && !text.endsWith("-")
                    && !text.endsWith("*") && !text.endsWith("/")) {
                    binding.txt.append("/")
                }
            }
            R.id.btn_nuqta->{
                val misol = binding.txt.text.toString()
                var amalIndex = -1
                if (!misol.endsWith("+") && !misol.endsWith("-") && !misol.endsWith("*") && !misol.endsWith("/")) {
                    for (i in misol.indices) {
                        if (misol[i] == '+' || misol[i] == '-' || misol[i] == '*' || misol[i] == '/') {
                            amalIndex = i
                        }
                    }
                    if (amalIndex == -1) {
                        if (!binding.txt.text.toString().contains('.')) {
                            binding.txt.append(".")
                        }
                    } else {
                        val ekranLength = binding.txt.text.length
                        val matn = binding.txt.text.toString().subSequence(amalIndex, ekranLength)
                        if (!matn.contains('.')) {
                            binding.txt.append(".")
                        }
                    }
                }
            }
            R.id.btn_clear->{
                binding.txt.text = "0"
            }
            R.id.btn_backsape->{
                val text = binding.txt.text.toString()
                if (text.contains("Formatda xatolik") || text.contains("No'lga bo'lib bo'lmaydi")){

                }else {
                    if (text != "") binding.txt.text = text.substring(0, text.length - 1)
                    if (text.length == 1 && binding.txt.callOnClick()) binding.txt.text = "0"
                }
            }
            R.id.btn_teng->{
                val text = binding.txt.text.toString()
                if (!text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") && !text.endsWith("/")) {
                    try {
                     //   throw ArithmeticException()
                        val build = ExpressionBuilder(binding.txt.text.toString()).build()
                        binding.txt.text = build.evaluate().toString()
                    }catch (a:ArithmeticException){
                       binding.txt.text = "No'lga bo'lib bo'lmaydi"
                    } catch (e:Exception){
                        binding.txt.text = "Formatda xatolik"
                    }
                }
            }
            R.id.txt->{
                val text = binding.txt.text.toString()
                if (text.contains("Formatda xatolik") || text.contains("No'lga bo'lib bo'lmaydi")){

                }else {
                    if (text != "") binding.txt.text = text.substring(0, text.length - 1)
                    if (text.length == 1 && binding.txt.callOnClick()) binding.txt.text = "0"
                }
            }

        }
    }

    private fun emptyAdd() {
        val text = binding.txt.text.toString()
        if (text == "0"){
            binding.txt.text = ""
        }
    }

    fun yangiYoz(){
        val text = binding.txt.text.toString()
        if (!text.contains("-") && !text.contains("+") && !text.contains("*") && !text.contains("/")){
            binding.txt.text = ""
        }
    }
}